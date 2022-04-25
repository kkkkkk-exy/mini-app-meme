package com.kkkkkk.miniappmeme.service.impl;

import com.kkkkkk.miniappmeme.entity.LabelOfAvatar;
import com.kkkkkk.miniappmeme.mapper.LabelMapper;
import com.kkkkkk.miniappmeme.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jennie
 * @create 2021-09-23 16:49
 */
@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    LabelMapper labelMapper;

    @Override
    public List<LabelOfAvatar> allLabel() {
        return labelMapper.selectAll();
    }

    @Override
    public int addLabel(String value){
        return labelMapper.insert(value);
    }

    @Override
    public LabelOfAvatar labelOfValue(String value){
        return labelMapper.selectByValue(value);
    }

    @Override
    public String valueOfId(Long id){
        return labelMapper.selectByPrimaryKey(id);
    }
}
