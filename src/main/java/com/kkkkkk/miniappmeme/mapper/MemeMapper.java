package com.kkkkkk.miniappmeme.mapper;

import com.kkkkkk.miniappmeme.entity.Meme;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Meme record);

    Meme selectByPrimaryKey(Long id);

    List<Meme> selectAll();

    int updateByPrimaryKey(Meme record);

    Long selectBySrc(String src);

    String selectSrcById(Long id);
}