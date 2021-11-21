package com.kkkkkk.miniappmeme.service.impl;

import com.kkkkkk.miniappmeme.entity.CategoryAvatar;
import com.kkkkkk.miniappmeme.mapper.CategoryAvatarMapper;
import com.kkkkkk.miniappmeme.service.CategoryAvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jennie
 * @create 2021-09-17 13:15
 */
@Service
public class CategoryAvatarServiceImpl implements CategoryAvatarService {

    @Autowired
    CategoryAvatarMapper categoryAvatarMapper;

    @Override
    public List<CategoryAvatar> allCategory(){
        return categoryAvatarMapper.selectAll();
    }

    @Override
    public int addCategory(String name){
        return categoryAvatarMapper.insert(name);
    }

    @Override
    public CategoryAvatar categoryOfName(String name){
        return categoryAvatarMapper.selectByName(name);
    }
}
