package com.kkkkkk.miniappmeme.service;

import com.kkkkkk.miniappmeme.entity.LabelOfAvatar;

import java.util.List;

/**
 * @author jennie
 * @create 2021-09-23 16:47
 */
public interface LabelService {
    List<LabelOfAvatar> allLabel();

    int addLabel(String value);

    LabelOfAvatar labelOfValue(String value);
}
