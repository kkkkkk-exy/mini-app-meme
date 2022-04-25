package com.kkkkkk.miniappmeme.controller;

import com.kkkkkk.miniappmeme.dto.UploadInfo;
import com.kkkkkk.miniappmeme.entity.CategoryMeme;
import com.kkkkkk.miniappmeme.entity.Meme;
import com.kkkkkk.miniappmeme.entity.MemeLabel;
import com.kkkkkk.miniappmeme.service.MemeService;
import com.kkkkkk.miniappmeme.service.impl.CategoryMemeServiceImpl;
import com.kkkkkk.miniappmeme.service.impl.MemeLabelServiceImpl;
import com.kkkkkk.miniappmeme.service.impl.MemeServiceImpl;
import com.kkkkkk.miniappmeme.util.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jennie
 * @create 2021-11-13 10:41
 */
@RestController
public class MemeController {
    @Autowired
    CategoryMemeServiceImpl categoryMemeService;

    @Autowired
    MemeLabelServiceImpl memeLabelService;

    @Autowired
    MemeServiceImpl memeService;

    //返回表情包的所有分类
    @GetMapping("/meme/categories")
    public Object getAllCategory(){
        List<CategoryMeme> categoryMemes = categoryMemeService.allCategory();
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("category_list", categoryMemes);
        return ResponseUtil.ok(data);
    }

    @GetMapping("/wechat/meme/categories")
    public Object getAllCategory_wechat(){
        List<CategoryMeme> categoryMemes = categoryMemeService.allCategory();
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("category_list", categoryMemes);
        return ResponseUtil.ok(data);
    }

    //增加表情包的分类
    @PostMapping("/meme/category/{name}")
    public Object addCategory(@PathVariable(value = "name") String name){
        if(categoryMemeService.categoryOfName(name) != null){
            return ResponseUtil.fail(401, "添加失败！该分类已存在");
        }

        categoryMemeService.addCategory(name);

        return ResponseUtil.ok(categoryMemeService.categoryOfName(name));
    }

    //上传头像
    @PostMapping("/meme")
    public Object addMeme(@RequestBody UploadInfo uploadInfo){
        int m = uploadInfo.getImageList().length;
        System.out.println("m=" + m);
        System.out.println(uploadInfo.getImageList()[0]);
        int n = uploadInfo.getLabels().length;
        System.out.println("n=" + n);
        int i = 0;
        int j = n;
        Long categoryId = uploadInfo.getCategoryId();
        Long memeId;

        while (m > 0){
            Meme meme = new Meme();
            System.out.println("i=" + i);
            String src = uploadInfo.getImageList()[i];
            i = i + 1;
            meme.setSrc(src);
            meme.setTime(new Date());
            meme.setCategory(categoryId);
            memeService.addMeme(meme);
            m--;
            System.out.println("m = " + m);

            j = n;
            while (j > 0){
                memeId = memeService.idOfSrc(src);
                Long labelId = uploadInfo.getLabels()[j-1];
                MemeLabel memeLabel = new MemeLabel();
                memeLabel.setIdMeme(memeId);
                memeLabel.setIdLabel(labelId);
                memeLabelService.add(memeLabel);
                j--;
            }
        }
        return ResponseUtil.ok();
    }

    //返回所有表情包
    @GetMapping("/wechat/memes")
    public Object allMeme(){
        return ResponseUtil.ok(memeService.allMeme());
    }

    //返回指定表情包
    @GetMapping("/wechat/meme/{id}")
    public Object getMeme(@PathVariable(value = "id")Long id){
        String src = memeService.srcOfId(id);
        System.out.println(src);
        return ResponseUtil.ok(src);
    }
}
