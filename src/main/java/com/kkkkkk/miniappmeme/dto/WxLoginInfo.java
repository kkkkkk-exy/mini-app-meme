package com.kkkkkk.miniappmeme.dto;

/**
 * @author jennie
 * @create 2021-08-30 19:22
 */
public class WxLoginInfo {
    private String code;
    private UserInfo userInfo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "WxLoginInfo{" +
                "code='" + code + '\'' +
                ", userInfo=" + userInfo.toString() +
                '}';
    }
}
