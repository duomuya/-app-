package com.cdut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: ExamService
 *   * Author:   healer
 *   * Date:     2020/7/24 23:01
 *   * Description: examservice启动类
 *  
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ExamService {
    public static void main(String[] args) {
        SpringApplication.run(ExamService.class,args);
    }
}
