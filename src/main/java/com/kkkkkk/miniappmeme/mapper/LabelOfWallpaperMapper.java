package com.kkkkkk.miniappmeme.mapper;

import com.kkkkkk.miniappmeme.entity.LabelOfWallpaper;
import java.util.List;

public interface LabelOfWallpaperMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LabelOfWallpaper record);

    LabelOfWallpaper selectByPrimaryKey(Long id);

    List<LabelOfWallpaper> selectAll();

    int updateByPrimaryKey(LabelOfWallpaper record);
}