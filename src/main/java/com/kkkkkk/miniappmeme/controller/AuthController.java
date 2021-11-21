package com.kkkkkk.miniappmeme.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kkkkkk.miniappmeme.dto.WxLoginInfo;
import com.kkkkkk.miniappmeme.entity.User;
import com.kkkkkk.miniappmeme.dto.UserInfo;
import com.kkkkkk.miniappmeme.model.OpenIdJson;
import com.kkkkkk.miniappmeme.service.impl.UserServiceImpl;
import com.kkkkkk.miniappmeme.util.HttpUtil;
import com.kkkkkk.miniappmeme.util.JwtTokenUtil;
import com.kkkkkk.miniappmeme.util.ResponseUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.PrimitiveIterator;

import static com.kkkkkk.miniappmeme.util.WxResponseCode.*;

/**
 * @author jennie
 * @create 2021-08-30 16:40
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private String appId = "wx01b8a94f04968753";

    private String appSecret = "6691bb7e999f82d26e65275a113361ab";

    private final Log logger = LogFactory.getLog(AuthController.class);

    @Autowired
    private UserServiceImpl userService;

    // @Autowired
    // private WxMaService wxService;

    //账号登录
    @PostMapping("/login")
    public Object login(@RequestBody User user, HttpServletRequest request){
        String username = user.getNickname();
        String password = user.getPassword();
        if (username == null || password == null){
            return ResponseUtil.badArgument();
        }

        User user1 = userService.queryByName(username);
        if (user1 == null){
            System.out.println("账号不存在");
            return ResponseUtil.fail(AUTH_INVALID_ACCOUNT, "账号不存在");
        }

        // BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //!encoder.matches(password, user1.getPassword())
        if (!password.equals(user1.getPassword())){
            System.out.println("账号密码不对");
            return ResponseUtil.fail(AUTH_INVALID_ACCOUNT, "账号密码不对");
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setNickName(username);

        String token = JwtTokenUtil.createToken(user1.getId(), false, new HashMap<>());

        Map<Object, Object> result = new HashMap<Object, Object>();
        result.put("token", token);
        result.put("userInfo", userInfo);
        return ResponseUtil.ok(result);
    }

    //微信登录
    //请求内容: { code: xxx, userInfo: xxx }
    @PostMapping("/login-weixin")
    public Object loginByWeixin(@RequestBody WxLoginInfo wxLoginInfo, HttpServletRequest request) throws IOException {
        String code = wxLoginInfo.getCode();
        UserInfo userInfo = wxLoginInfo.getUserInfo();
        if (code == null || userInfo == null){
            return ResponseUtil.badArgument();
        }

        String sessionKey = null;
        String openId = null;
        String result = "";
        //如果code是错误的咋处理
        try {
            result = HttpUtil.doGet("https://api.weixin.qq.com/sns/jscode2session?appid="
                                    + this.appId + "&secret=" + this.appSecret + "&js_code=" + code
                                    + "&grant_type=authorization_code", null);

        } catch (Exception e){
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        OpenIdJson openIdJson = mapper.readValue(result, OpenIdJson.class);

        openId = openIdJson.getOpenid();
        sessionKey = openIdJson.getSession_key();

        User user = userService.queryByOid(openId);
        if (user == null) {
            user = new User();
            //怎么样处理username password比较好呢，因为使用账号登录的只有很少的，这样感觉蛮浪费的，要不分两张表好了？
            user.setPassword(openId);
            user.setWeixinOpenid(openId);
            user.setAvatar(userInfo.getAvatarUrl());
            user.setNickname(userInfo.getNickName());
            user.setLastLoginTime(LocalDateTime.now());
            //其实不知道sessionKey是干什么用的
            user.setSessionKey(sessionKey);

            userService.addUser(user);
            user = userService.queryByOid(openId);
        } else {
            System.out.println("im coming");
            //更新用户信息  看看等一下要不要加上顺便更新userInfo
            user.setLastLoginTime(LocalDateTime.now());
            user.setSessionKey(sessionKey);

            if(userService.updateUserMsg(user) == 0){
                return ResponseUtil.updatedDataFailed();
            }
        }

        //不是新用户的这里的user是没有id的啊
        String token = JwtTokenUtil.createToken(user.getId(), false, new HashMap<>());

        Map<Object, Object> result1 = new HashMap<Object, Object>();
        result1.put("token", token);
        result1.put("userInfo", userInfo);
        return ResponseUtil.ok(result1);
    }


}
