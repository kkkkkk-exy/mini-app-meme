package com.kkkkkk.miniappmeme.mapper;

import com.kkkkkk.miniappmeme.entity.Carousel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarouselMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Carousel record);

    Carousel selectByPrimaryKey(Long id);

    List<Carousel> selectAll();

    int updateByPrimaryKey(Carousel record);
}