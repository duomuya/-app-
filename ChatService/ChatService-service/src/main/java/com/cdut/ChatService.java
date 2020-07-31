package com.cdut;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: ChatService
 *   * Author:   healer
 *   * Date:     2020/7/24 22:53
 *   * Description: chatservice启动类
 *  
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling  //开启定时任务
@MapperScan("com.cdut.mapper")
public class ChatService {
    public static void main(String[] args) {
        SpringApplication.run(ChatService.class,args);
    }
}
