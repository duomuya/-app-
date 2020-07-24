package com.cdut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: HomeworkService
 *   * Author:   healer
 *   * Date:     2020/7/24 23:01
 *   * Description: homeworkservice启动类
 *  
 */
@SpringBootApplication
@EnableDiscoveryClient
public class HomeworkService {
    public static void main(String[] args) {
        SpringApplication.run(HomeworkService.class,args);
    }
}
