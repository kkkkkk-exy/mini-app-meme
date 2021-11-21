package com.kkkkkk.miniappmeme.mapper;

import com.kkkkkk.miniappmeme.entity.LabelOfSentence;
import java.util.List;

public interface LabelOfSentenceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LabelOfSentence record);

    LabelOfSentence selectByPrimaryKey(Long id);

    List<LabelOfSentence> selectAll();

    int updateByPrimaryKey(LabelOfSentence record);
}