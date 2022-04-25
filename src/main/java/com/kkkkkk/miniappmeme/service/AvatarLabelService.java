package com.kkkkkk.miniappmeme.service;

import com.kkkkkk.miniappmeme.entity.AvatarLabel;

import java.util.List;

/**
 * @author jennie
 * @create 2021-09-29 11:52
 */
public interface AvatarLabelService {
    int add(AvatarLabel avatarLabel);

    List<Long> avatarOfLabel(Long labelId);

    List<Long> labelOfAvatar(Long avatarId);
}
