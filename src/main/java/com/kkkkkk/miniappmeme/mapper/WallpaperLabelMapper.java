package com.kkkkkk.miniappmeme.mapper;

import com.kkkkkk.miniappmeme.entity.WallpaperLabel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WallpaperLabelMapper {
    int deleteByPrimaryKey(@Param("idWallpaper") Long idWallpaper, @Param("idLabel") Long idLabel);

    int insert(WallpaperLabel record);

    List<WallpaperLabel> selectAll();
}