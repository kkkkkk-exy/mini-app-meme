package com.kkkkkk.miniappmeme.controller;

import com.kkkkkk.miniappmeme.entity.Avatar;
import com.kkkkkk.miniappmeme.service.AvatarService;
import com.kkkkkk.miniappmeme.service.impl.AvatarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jennie
 * @create 2021-09-02 0:34
 */
@RestController
public class testController {

    @Autowired
    AvatarServiceImpl avatarService;

    @GetMapping("/hello")
    public String helloTest(){
        return "hello! Congratulations";
    }

    @GetMapping("auth/avatar")
    public List<Avatar> allAvatar(){
        return avatarService.allAvatar();
    }
}
