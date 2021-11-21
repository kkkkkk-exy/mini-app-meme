package com.kkkkkk.miniappmeme.service;

import com.kkkkkk.miniappmeme.entity.Carousel;

import java.util.List;

/**
 * @author jennie
 * @create 2021-10-16 1:06
 */
public interface CarouselService {
    int addCarousel(Carousel carousel);

    List<Carousel> allCarousel();
}
