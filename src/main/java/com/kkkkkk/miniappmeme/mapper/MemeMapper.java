package com.kkkkkk.miniappmeme.mapper;

import com.kkkkkk.miniappmeme.entity.Meme;
import java.util.List;

public interface MemeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Meme record);

    Meme selectByPrimaryKey(Long id);

    List<Meme> selectAll();

    int updateByPrimaryKey(Meme record);
}