package com.kkkkkk.miniappmeme.service.impl;

import com.kkkkkk.miniappmeme.entity.MemeLabel;
import com.kkkkkk.miniappmeme.mapper.MemeLabelMapper;
import com.kkkkkk.miniappmeme.service.MemeLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jennie
 * @create 2021-11-13 11:19
 */
@Service
public class MemeLabelServiceImpl implements MemeLabelService {
    @Autowired
    MemeLabelMapper memeLabelMapper;

    @Override
    public int add(MemeLabel memeLabel) {
        return memeLabelMapper.insert(memeLabel);
    }

    @Override
    public List<Long> memeOfLabel(Long labelId) {
        return memeLabelMapper.selectByLabelId(labelId);
    }
}
