package com.kkkkkk.miniappmeme.util;

import java.util.UUID;

/**
 * @author jennie
 * @create 2021-10-10 16:08
 * 生成唯一图片名称
 */
public class StringUtil {
    public static String getRandomImgName(String fileName) throws IllegalAccessException {
        int index = fileName.lastIndexOf('.');
        if ((fileName == null || fileName.isEmpty()) || index == -1){
            throw new IllegalAccessException();
        }

        //获取文件后缀
        String suffix = fileName.substring(index);
        //生成UUID
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String path = uuid + suffix;
        return path;
    }
}
