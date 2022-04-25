package com.kkkkkk.miniappmeme.service.impl;

import com.kkkkkk.miniappmeme.entity.AvatarLabel;
import com.kkkkkk.miniappmeme.mapper.AvatarLabelMapper;
import com.kkkkkk.miniappmeme.service.AvatarLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jennie
 * @create 2021-09-29 11:53
 */
@Service
public class AvatarLabelServiceImpl implements AvatarLabelService {

    @Autowired
    AvatarLabelMapper avatarLabelMapper;

    @Override
    public int add(AvatarLabel avatarLabel){
        return avatarLabelMapper.insert(avatarLabel);
    }

    @Override
    public List<Long> avatarOfLabel(Long labelId){
        return avatarLabelMapper.selectByLabelId(labelId);
    }

    @Override
    public List<Long> labelOfAvatar(Long avatarId){
        return avatarLabelMapper.selectByAvatarId(avatarId);
    }
}
