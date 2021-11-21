package com.kkkkkk.miniappmeme.mapper;

import com.kkkkkk.miniappmeme.entity.Sentence;
import java.util.List;

public interface SentenceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Sentence record);

    Sentence selectByPrimaryKey(Long id);

    List<Sentence> selectAll();

    int updateByPrimaryKey(Sentence record);
}