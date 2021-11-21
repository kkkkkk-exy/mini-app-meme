package com.kkkkkk.miniappmeme.mapper;

import com.kkkkkk.miniappmeme.entity.CategorySentence;
import java.util.List;

public interface CategorySentenceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CategorySentence record);

    CategorySentence selectByPrimaryKey(Long id);

    List<CategorySentence> selectAll();

    int updateByPrimaryKey(CategorySentence record);
}