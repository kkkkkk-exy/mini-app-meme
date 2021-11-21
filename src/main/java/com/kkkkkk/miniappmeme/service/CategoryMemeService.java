package com.kkkkkk.miniappmeme.service;

import com.kkkkkk.miniappmeme.entity.CategoryMeme;

import java.util.List;

/**
 * @author jennie
 * @create 2021-11-13 0:02
 */
public interface CategoryMemeService {
    //返回所有分类
    List<CategoryMeme> allCategory();

    //增加头像分类
    int addCategory(String name);

    //查询分类是否已存在
    CategoryMeme categoryOfName(String name);

}
