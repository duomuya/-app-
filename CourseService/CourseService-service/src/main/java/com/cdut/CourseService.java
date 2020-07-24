package com.cdut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: CourseService
 *   * Author:   healer
 *   * Date:     2020/7/24 22:59
 *   * Description: courseservice启动类
 *  
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CourseService {
    public static void main(String[] args) {
        SpringApplication.run(CourseService.class,args);
    }
}
