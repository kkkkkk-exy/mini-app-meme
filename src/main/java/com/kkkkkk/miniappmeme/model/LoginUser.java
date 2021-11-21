package com.kkkkkk.miniappmeme.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author jennie
 * @create 2021-09-01 20:15
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginUser {
    private Long id;
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
