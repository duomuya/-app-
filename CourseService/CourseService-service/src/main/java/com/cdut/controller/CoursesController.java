package com.cdut.controller;

import com.cdut.pojo.Courses;
import com.cdut.service.CoursesService;
import com.cdut.pojo.Result;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Path;

@RestController
public class CoursesController {
    @Autowired
    CoursesService coursesService;

    @RequestMapping(path = "/queryAll")
    public Result queryAll(){
        return Result.success(coursesService.queryAll());
    }

    @RequestMapping(path = "/queryById/{id}")
    public Result queryById(@PathVariable String id ){
        return Result.success(coursesService.queryById(id));
    }

    @RequestMapping(path = "/add")
    public Result add(Courses courses){
        return Result.success(coursesService.addCourses(courses));
    }

    @RequestMapping(path = "/update")
    public Result update(Courses courses){
        coursesService.updateCourses(courses);
        return Result.success();
    }
    @RequestMapping(path = "del/{id}")
    public Result del(@PathVariable String id){
        coursesService.delById(id);
        return Result.success();
    }

    @RequestMapping(path = "/batchDel")
    public Result batchDel(String[] course_idList){
        coursesService.batchDel(course_idList);
        return Result.success();
    }

    @GetMapping(path = "/courses/{user_id}")
    public String paging(int page, int limit, @PathVariable String user_id){
        JSONObject pagingDate=new JSONObject(Result.success(coursesService.paging(page, limit, user_id)));
        pagingDate.put("count",coursesService.getCourseCount(user_id));
        return pagingDate.toString();
    }

    @ResponseBody
    @RequestMapping(path = "/uploadCourses")
    public Result uploadCourses(HttpServletRequest request, @RequestParam(value = "courseVideos[]")MultipartFile[] courseVideos, @RequestParam(value = "course_id")String course_id) throws IOException {
        System.out.println(courseVideos.length);
       return coursesService.uploadCourses(request,courseVideos,course_id);
    }
}
