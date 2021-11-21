package com.kkkkkk.miniappmeme.service.impl;

import com.kkkkkk.miniappmeme.entity.User;
import com.kkkkkk.miniappmeme.mapper.UserMapper;
import com.kkkkkk.miniappmeme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jennie
 * @create 2021-08-30 16:09
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public User queryByName(String name) {
        return userMapper.userOfName(name);
    }

    @Override
    public User queryByOid(String openId) {
        return userMapper.userOfOid(openId);
    }

    @Override
    public int updateUserMsg(User user) {
        return userMapper.updateById(user);
    }
}
