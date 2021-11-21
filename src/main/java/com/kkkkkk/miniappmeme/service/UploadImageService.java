package com.kkkkkk.miniappmeme.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author jennie
 * @create 2021-10-10 16:18
 */
public interface UploadImageService {
    String uploadQNImg(MultipartFile file);

    String getPrivateFile(String fileKey);

    boolean removeFile(String bucket, String fileKey);
}
