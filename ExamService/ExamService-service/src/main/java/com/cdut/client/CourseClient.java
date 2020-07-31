package com.cdut.client;

import com.cdut.api.CoursesApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: CourseClient
 *   * Author:   healer
 *   * Date:     2020/7/29 19:24
 *   * Description:
 *  
 */
@FeignClient(value = "courseService")
@ComponentScan
public interface CourseClient extends CoursesApi {

}
