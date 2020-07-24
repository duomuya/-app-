package com.cdut.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: CdutZuulApplication
 *   * Author:   healer
 *   * Date:     2020/7/24 23:22
 *   * Description: zuul启动类
 *  
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class CdutZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(CdutZuulApplication.class,args);
    }
}
