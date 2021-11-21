package com.kkkkkk.miniappmeme.mapper;

import com.kkkkkk.miniappmeme.entity.CategoryWallpaper;
import java.util.List;

public interface CategoryWallpaperMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CategoryWallpaper record);

    CategoryWallpaper selectByPrimaryKey(Long id);

    List<CategoryWallpaper> selectAll();

    int updateByPrimaryKey(CategoryWallpaper record);
}