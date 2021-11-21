package com.kkkkkk.miniappmeme.controller;

import com.kkkkkk.miniappmeme.entity.Carousel;
import com.kkkkkk.miniappmeme.service.impl.CarouselServiceImpl;
import com.kkkkkk.miniappmeme.service.impl.UploadImageServiceImpl;
import com.kkkkkk.miniappmeme.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * @author jennie
 * @create 2021-10-16 9:15
 */
@RestController
public class CarouselController {

    @Autowired
    CarouselServiceImpl carouselService;

    @Autowired
    UploadImageServiceImpl uploadImageService;

    //上传图片到七牛云
    // @PostMapping("/upload")
    // private Object uploadImg(@RequestParam("file") MultipartFile file, Model model){
    //
    //     if(!file.isEmpty()){
    //         String path = uploadImageService.uploadQNImg(file);
    //         System.out.println("七牛云返回的图片链接" + path);
    //         model.addAttribute("link", path);
    //         return ResponseUtil.ok(path);
    //     }
    //     return ResponseUtil.fail();
    // }

    //增加轮播图
    @PostMapping("/carousel")
    public Object addCarousel(@RequestBody List<String> imgList){
        int length = imgList.size();
        while (length > 0){
            Carousel carousel = new Carousel();
            carousel.setSrc(imgList.get(length-1));
            carousel.setTime(new Date());
            carouselService.addCarousel(carousel);
            length--;
        }
        return ResponseUtil.ok();
    }

    //返回轮播图
    @GetMapping("/wechat/carousel")
    public Object getCarousel(){
        List<Carousel> carouselList = carouselService.allCarousel();
        int i = 3;
        // while(i){
        //
        // }
        return ResponseUtil.ok(carouselList);
    }





}
