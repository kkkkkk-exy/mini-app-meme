package com.kkkkkk.miniappmeme.mapper;

import com.kkkkkk.miniappmeme.entity.LabelOfAvatar;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(String value);

    String selectByPrimaryKey(Long id);

    List<LabelOfAvatar> selectAll();

    int updateByPrimaryKey(LabelOfAvatar record);

    LabelOfAvatar selectByValue(String value);
}