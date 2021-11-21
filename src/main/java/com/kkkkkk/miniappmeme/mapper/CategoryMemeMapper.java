package com.kkkkkk.miniappmeme.mapper;

import com.kkkkkk.miniappmeme.entity.CategoryMeme;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMemeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(String name);

    CategoryMeme selectByPrimaryKey(Long id);

    List<CategoryMeme> selectAll();

    int updateByPrimaryKey(CategoryMeme record);

    CategoryMeme selectByName(String name);
}