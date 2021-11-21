package com.kkkkkk.miniappmeme.service.impl;

import com.kkkkkk.miniappmeme.entity.Carousel;
import com.kkkkkk.miniappmeme.mapper.CarouselMapper;
import com.kkkkkk.miniappmeme.service.CarouselService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jennie
 * @create 2021-10-16 1:08
 */
@Service
public class CarouselServiceImpl implements CarouselService{

    @Autowired
    CarouselMapper carouselMapper;

    @Override
    public int addCarousel(Carousel carousel){
        return carouselMapper.insert(carousel);
    }

    @Override
    public List<Carousel> allCarousel() {
        return carouselMapper.selectAll();
    }
}
