package com.kkkkkk.miniappmeme.service.impl;

import com.google.gson.Gson;
import com.kkkkkk.miniappmeme.config.QiNiuYunConfig;
import com.kkkkkk.miniappmeme.service.UploadImageService;
import com.kkkkkk.miniappmeme.util.StringUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author jennie
 * @create 2021-10-10 16:22
 */
@Service
public class UploadImageServiceImpl implements UploadImageService {

    private QiNiuYunConfig qiNiuYunConfig;

    //七牛文件上传管理器
    private UploadManager uploadManager;
    //上传的token
    private String token;
    //七牛认证管理
    private Auth auth;

    private BucketManager bucketManager;


    public UploadImageServiceImpl(QiNiuYunConfig qiNiuYunConfig){
        this.qiNiuYunConfig = qiNiuYunConfig;
        init();
    }

    private void init() {
        uploadManager = new UploadManager(new Configuration(Zone.zone2()));
        auth = Auth.create(qiNiuYunConfig.getAccessKey(), qiNiuYunConfig.getSecretKey());
        bucketManager = new BucketManager(auth, new Configuration(Zone.zone2()));
        token = auth.uploadToken(qiNiuYunConfig.getBucket());

    }

    //上传文件
    @Override
    public String uploadQNImg(MultipartFile file){
        try {
            //获取文件名称
            String fileName = file.getOriginalFilename();
            //生成图片名称
            String imgName = StringUtil.getRandomImgName(fileName);

            FileInputStream inputStream = (FileInputStream) file.getInputStream();
            //上传图片文件
            Response res = uploadManager.put(inputStream, imgName, token, null, null);
            if(!res.isOK()){
                throw new RuntimeException("上传七牛云出错" + res.toString());
            }

            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(res.bodyString(), DefaultPutRet.class);

            return getPrivateFile(imgName);

        } catch (QiniuException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    //获取私有空间文件
    @Override
    public String getPrivateFile(String fileKey){
        String encodeFileName = null;
        String finalUrl = null;
        try{
            encodeFileName = URLEncoder.encode(fileKey, "utf-8").replace("+", "%20");
            String publicUrl = String.format("%s/%s", this.qiNiuYunConfig.getUrl(), encodeFileName);
            long expireInSecond = 36000000;
            finalUrl = auth.privateDownloadUrl(publicUrl, expireInSecond);
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return finalUrl;
    }

    // 根据空间名、文件名删除文件
    @Override
    public boolean removeFile(String bucketName, String fileKey){
        try {
            bucketManager.delete(bucketName, fileKey);
        } catch (QiniuException e){
            e.printStackTrace();
        }
        return true;
    }

}
