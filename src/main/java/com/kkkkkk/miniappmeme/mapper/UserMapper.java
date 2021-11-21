package com.kkkkkk.miniappmeme.mapper;

import com.kkkkkk.miniappmeme.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jennie
 * @create 2021-08-28 23:04
 */
@Repository
public interface UserMapper {
    int insertSelective(User user);

    User userOfName(String name);

    User userOfOid(String openId);

    int updateById(User user);


}