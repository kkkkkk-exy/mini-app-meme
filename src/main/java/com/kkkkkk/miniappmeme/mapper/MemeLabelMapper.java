package com.kkkkkk.miniappmeme.mapper;

import com.kkkkkk.miniappmeme.entity.MemeLabel;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemeLabelMapper {
    int deleteByPrimaryKey(@Param("idMeme") Long idMeme, @Param("idLabel") Long idLabel);

    int insert(MemeLabel record);

    List<MemeLabel> selectAll();

    List<Long> selectByLabelId(Long LabelId);
}