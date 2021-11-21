package com.kkkkkk.miniappmeme.mapper;

import com.kkkkkk.miniappmeme.entity.SentenceLabel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SentenceLabelMapper {
    int deleteByPrimaryKey(@Param("idSentence") Long idSentence, @Param("idLabel") Long idLabel);

    int insert(SentenceLabel record);

    List<SentenceLabel> selectAll();
}