package com.kkkkkk.miniappmeme.mapper;

import com.kkkkkk.miniappmeme.entity.CategoryAvatar;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryAvatarMapper {
    int deleteByPrimaryKey(Long id);

    int insert(String name);

    CategoryAvatar selectByPrimaryKey(Long id);

    List<CategoryAvatar> selectAll();

    int updateByPrimaryKey(CategoryAvatar record);

    CategoryAvatar selectByName(String name);
}