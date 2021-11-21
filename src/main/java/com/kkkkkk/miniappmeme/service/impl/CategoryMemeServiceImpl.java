package com.kkkkkk.miniappmeme.service.impl;

import com.kkkkkk.miniappmeme.entity.CategoryMeme;
import com.kkkkkk.miniappmeme.mapper.CategoryMemeMapper;
import com.kkkkkk.miniappmeme.service.CategoryMemeService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jennie
 * @create 2021-11-13 0:18
 */
@Service
public class CategoryMemeServiceImpl implements CategoryMemeService {
    @Autowired
    CategoryMemeMapper categoryMemeMapper;

    @Override
    public List<CategoryMeme> allCategory() {
        return categoryMemeMapper.selectAll();
    }

    @Override
    public int addCategory(String name){
        return categoryMemeMapper.insert(name);
    }

    @Override
    public CategoryMeme categoryOfName(String name) {
        return categoryMemeMapper.selectByName(name);
    }
}
