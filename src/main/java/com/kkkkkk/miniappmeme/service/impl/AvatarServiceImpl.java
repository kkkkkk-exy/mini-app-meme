package com.kkkkkk.miniappmeme.service.impl;

import com.kkkkkk.miniappmeme.entity.Avatar;
import com.kkkkkk.miniappmeme.mapper.AvatarMapper;
import com.kkkkkk.miniappmeme.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jennie
 * @create 2021-09-02 1:07
 */
@Service
public class AvatarServiceImpl implements AvatarService {
    @Autowired
    AvatarMapper avatarMapper;

    @Override
    public List<Avatar> allAvatar(){
        return avatarMapper.selectAll();
    }

    @Override
    public int addAvatar(Avatar avatar) {
        return avatarMapper.insert(avatar);
    }

    @Override
    public Long avatarOfSrc(String src){
        return avatarMapper.selectBySrc(src);
    }

    @Override
    public String srcOfId(Long id){
        return avatarMapper.selectByPrimaryKey(id).getSrc();
    }

    @Override
    public List<Avatar> avatarOfCategory(Long id){
        return avatarMapper.selectByCategory(id);
    }
}
