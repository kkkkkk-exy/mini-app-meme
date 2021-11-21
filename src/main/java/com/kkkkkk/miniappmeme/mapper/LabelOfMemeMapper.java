package com.kkkkkk.miniappmeme.mapper;

import com.kkkkkk.miniappmeme.entity.LabelOfMeme;
import java.util.List;

public interface LabelOfMemeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LabelOfMeme record);

    LabelOfMeme selectByPrimaryKey(Long id);

    List<LabelOfMeme> selectAll();

    int updateByPrimaryKey(LabelOfMeme record);
}