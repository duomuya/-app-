package com.cdut.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: CdutEurekaApplication
 *   * Author:   healer
 *   * Date:     2020/7/24 23:23
 *   * Description: eureka启动类
 *  
 */
@SpringBootApplication
@EnableEurekaServer   //声明当前的应用是eureka服务中心
public class CdutEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(CdutEurekaApplication.class,args);
    }
}
