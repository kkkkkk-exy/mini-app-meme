package com.kkkkkk.miniappmeme.mapper;

import com.kkkkkk.miniappmeme.entity.AvatarLabel;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarLabelMapper {
    int deleteByPrimaryKey(@Param("idAvatar") Long idAvatar, @Param("idLabel") Long idLabel);

    int insert(AvatarLabel record);

    List<AvatarLabel> selectAll();

    List<Long> selectByLabelId(Long LabelId);
}