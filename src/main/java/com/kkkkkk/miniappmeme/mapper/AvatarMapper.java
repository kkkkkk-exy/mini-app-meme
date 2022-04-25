package com.kkkkkk.miniappmeme.mapper;

import com.kkkkkk.miniappmeme.entity.Avatar;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AvatarMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Avatar record);

    Avatar selectByPrimaryKey(Long id);

    List<Avatar> selectAll();

    int updateByPrimaryKey(Avatar record);

    Long selectBySrc(String src);

    List<Avatar> selectByCategory(Long id);
}