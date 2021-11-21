package com.kkkkkk.miniappmeme.controller;

import com.kkkkkk.miniappmeme.service.impl.UploadImageServiceImpl;
import com.kkkkkk.miniappmeme.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author jennie
 * @create 2021-10-13 12:30
 */
@RestController
public class UploadController {

    @Autowired
    UploadImageServiceImpl uploadImageService;

    @PostMapping("/image")
    private Object uploadImg(@RequestParam("file")MultipartFile file, Model model){
        if(!file.isEmpty()){
            String path = uploadImageService.uploadQNImg(file);
            System.out.println("七牛云返回的图片链接" + path);
            model.addAttribute("link", path);
            return ResponseUtil.ok(path);
        }
        return ResponseUtil.fail();
    }
    @GetMapping("/upload")
    public String upload(){
        return "upload";
    }
}
