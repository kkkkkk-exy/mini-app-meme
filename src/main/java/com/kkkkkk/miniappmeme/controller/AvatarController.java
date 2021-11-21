package com.kkkkkk.miniappmeme.controller;

import com.kkkkkk.miniappmeme.dto.UploadInfo;
import com.kkkkkk.miniappmeme.dto.SearchLabelResponse;
import com.kkkkkk.miniappmeme.dto.SearchParam;
import com.kkkkkk.miniappmeme.entity.Avatar;
import com.kkkkkk.miniappmeme.entity.AvatarLabel;
import com.kkkkkk.miniappmeme.entity.CategoryAvatar;
import com.kkkkkk.miniappmeme.entity.LabelEsModel;
import com.kkkkkk.miniappmeme.service.impl.*;
import com.kkkkkk.miniappmeme.util.PageUtil;
import com.kkkkkk.miniappmeme.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * @author jennie
 * @create 2021-09-17 13:26
 */
@RestController
// @RequestMapping("/avatar")
public class AvatarController {

    @Autowired
    CategoryAvatarServiceImpl categoryAvatarService;

    @Autowired
    LabelServiceImpl labelOfAvatarService;

    @Autowired
    AvatarServiceImpl avatarService;

    @Autowired
    AvatarLabelServiceImpl labelService;

    @Autowired
    UploadImageServiceImpl uploadImageService;

    @Autowired
    SearchAvatarServiceImpl searchAvatarService;

    //返回头像的所有分类
    @GetMapping("/avatar/categories")
    public Object getAllCategory(){
        List<CategoryAvatar> categoryAvatars = categoryAvatarService.allCategory();
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("category_list", categoryAvatars);
        return ResponseUtil.ok(data);
    }

    // @GetMapping("/upload")
    // public String upload(){
    //     return "upload";
    // }

    //上传图片到七牛云
    @PostMapping("/upload")
    private Object uploadImg(@RequestParam("file")MultipartFile file, Model model){

        if(!file.isEmpty()){
            String path = uploadImageService.uploadQNImg(file);
            System.out.println("七牛云返回的图片链接" + path);
            model.addAttribute("link", path);
            return ResponseUtil.ok(path);
        }
        return ResponseUtil.fail();
    }

    //增加头像的分类
    @PostMapping("/avatar/category/{name}")
    public Object addCategory(@PathVariable(value = "name") String name){
        if(categoryAvatarService.categoryOfName(name) != null){
            return ResponseUtil.fail(401, "添加失败！该分类已存在");
        }

        categoryAvatarService.addCategory(name);

        return ResponseUtil.ok(categoryAvatarService.categoryOfName(name));
    }

    // @PostMapping("/upload")
    // public Object upload(@RequestParam("file")MultipartFile file) throws Exception {
    //     String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
    //     byte[] data = file.getBytes();
    //
    //     return ResponseUtil.ok(data);
    // }

    //查询头像的所有标签
    @GetMapping("/labels")
    public Object getlabels(){
        return ResponseUtil.ok(labelOfAvatarService.allLabel());
    }

    //增加标签
    @PostMapping("/label/{value}")
    public Object addLabel(@PathVariable(value = "value")String value){
        if (labelOfAvatarService.labelOfValue(value) != null){
            return ResponseUtil.fail(401, "该标签已存在");
        }

        labelOfAvatarService.addLabel(value);
        return ResponseUtil.ok();
    }

    // 上传头像
    @PostMapping("/avatar")
    public Object addAvatar(@RequestBody UploadInfo uploadInfo){
        int m = uploadInfo.getImageList().length;
        System.out.println("m=" + m);
        System.out.println(uploadInfo.getImageList()[0]);
        int n = uploadInfo.getLabels().length;
        System.out.println("n=" + n);
        int i = 0;
        int j = n;
        Long categoryId = uploadInfo.getCategoryId();
        Long avatarId;

        while (m > 0){
            Avatar avatar = new Avatar();
            System.out.println("i=" + i);
            String src = uploadInfo.getImageList()[i];
            i = i + 1;
            avatar.setSrc(src);
            avatar.setTime(new Date());
            avatar.setCategory(categoryId);
            avatarService.addAvatar(avatar);
            m--;
            System.out.println("m = " + m);

            j = n;
            while(j > 0){
                avatarId = avatarService.avatarOfSrc(src);
                // if(avatarIdList.size() > 1){
                //     return ResponseUtil.fail(710, "第" + i + "个图片已存在，请去掉此图片重新上传");
                // } else {
                //     avatarId = avatarIdList.get(0);
                // }
                Long labelId = uploadInfo.getLabels()[j-1];
                AvatarLabel avatarLabel = new AvatarLabel();
                avatarLabel.setIdAvatar(avatarId);
                avatarLabel.setIdLabel(labelId);
                labelService.add(avatarLabel);
                j--;
            }
        }
        return ResponseUtil.ok();
    }

    //返回所有头像
    @GetMapping("/wechat/avatar")
    public Object allAvatar(){
        return ResponseUtil.ok(avatarService.allAvatar());
    }

    //搜索头像
    @PostMapping("/wechat/search/{pageNum}/{pageSize}")
    public Object searchAvatar(@RequestBody SearchParam param, @PathVariable(value = "pageNum")Integer pageNum, @PathVariable(value = "pageSize")Integer pageSize){
        SearchLabelResponse labelResponse = searchAvatarService.searchAvatar(param);
        int lengthLabel = Math.toIntExact(labelResponse.getTotal());
        List<LabelEsModel> labelList = labelResponse.getLabelList();
        Set<Long> avatarIdList = new HashSet<Long>();

        for (int n = lengthLabel; n > 0; n--){
            Long labelId = labelList.get(n-1).getId();
            avatarIdList.addAll(labelService.avatarOfLabel(labelId));
        }
        Long[] avatarList = avatarIdList.toArray(new Long[avatarIdList.size()]);

        int lengthAvatar  = avatarIdList.size();
        List<String> srcList = new ArrayList<>();
        for (int n = lengthAvatar; n > 0; n--){
            srcList.add(avatarService.srcOfId(avatarList[n-1]));
        }

        return ResponseUtil.ok(PageUtil.startPage(srcList, pageNum, pageSize));
    }


}
