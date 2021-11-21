package com.kkkkkk.miniappmeme.mapper;

import com.kkkkkk.miniappmeme.entity.Wallpaper;
import java.util.List;

public interface WallpaperMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Wallpaper record);

    Wallpaper selectByPrimaryKey(Long id);

    List<Wallpaper> selectAll();

    int updateByPrimaryKey(Wallpaper record);
}