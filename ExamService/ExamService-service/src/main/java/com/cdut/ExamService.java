package com.cdut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

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
@EnableFeignClients
@EnableCircuitBreaker  //开启熔断
public class ExamService {
    public static void main(String[] args) {
        SpringApplication.run(ExamService.class,args);
    }
}
