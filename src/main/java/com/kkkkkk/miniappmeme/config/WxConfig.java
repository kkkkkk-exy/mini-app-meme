package com.kkkkkk.miniappmeme.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jennie
 * @create 2021-08-30 20:31
 */
@Configuration
public class WxConfig {
    @Bean
    public WxMaService wxMaService() {
        WxMaService wxMaService = new WxMaServiceImpl();
        return wxMaService;
    }
}
