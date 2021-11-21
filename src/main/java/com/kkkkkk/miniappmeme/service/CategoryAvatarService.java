package com.kkkkkk.miniappmeme.service;

import com.kkkkkk.miniappmeme.entity.CategoryAvatar;

import java.util.List;

/**
 * @author jennie
 * @create 2021-09-17 13:12
 */
public interface CategoryAvatarService {
    //返回所有分类
    List<CategoryAvatar> allCategory();

    //增加头像分类
    int addCategory(String name);

    //查询分类是否已存在
    CategoryAvatar categoryOfName(String name);
}
