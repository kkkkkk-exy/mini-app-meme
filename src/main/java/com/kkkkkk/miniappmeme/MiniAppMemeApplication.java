package com.kkkkkk.miniappmeme;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kkkkkk.miniappmeme.mapper")
public class MiniAppMemeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniAppMemeApplication.class, args);
    }

}
