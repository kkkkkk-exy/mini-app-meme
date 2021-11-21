package com.kkkkkk.miniappmeme.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author jennie
 * @create 2021-10-10 16:03
 */
@Configuration
public class QiNiuYunConfig {
    @Value("${oss.qiniu.accesskey}")
    private String accessKey;

    @Value("${oss.qiniu.bucket}")
    private String bucket;

    @Value("${oss.qiniu.secretKey}")
    private String secretKey;

    @Value("${oss.qiniu.domain}")
    private String url;

    public String getAccessKey() {
        return accessKey;
    }

    public String getBucket() {
        return bucket;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getUrl() {
        return url;
    }
}
