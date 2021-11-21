package com.kkkkkk.miniappmeme.service;

import com.kkkkkk.miniappmeme.entity.User;

import java.util.List;

/**
 * @author jennie
 * @create 2021-08-29 22:05
 */
public interface UserService {

    int addUser(User user);

    User queryByName(String name);

    User queryByOid(String openId);

    int updateUserMsg(User user);
}
