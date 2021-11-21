package com.kkkkkk.miniappmeme.service;

import com.kkkkkk.miniappmeme.entity.MemeLabel;

import java.util.List;

/**
 * @author jennie
 * @create 2021-11-13 11:01
 */
public interface MemeLabelService {
    int add(MemeLabel memeLabel);

    List<Long> memeOfLabel(Long labelId);
}
