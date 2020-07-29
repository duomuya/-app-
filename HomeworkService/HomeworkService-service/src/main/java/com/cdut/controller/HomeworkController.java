package com.cdut.controller;

import com.cdut.pojo.Homework;
import com.cdut.service.HomeworkService;
import com.cdut.utils.Result;
import com.cdut.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fan
 * @package com.cdut.controller
 * @date 2020/7/26 12:43
 */
@RestController
@RequestMapping("homework")
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;

    @RequestMapping(value = "hello")
    public String hello(){
        return "hello";
    }

    /**
     * @discript 返回json数据
     *            http://localhost:8084/homework/findAll 不通过网关
     *            http://desktop-t6igd80:10010/eduapp/homeworkservice/homework/findAll 通过网关
     * @param
     * @return java.util.List<com.cdut.pojo.Homework>
     * @author fan
     * @date 2020/7/26 15:49
     */
    @RequestMapping(value = "findAll", method = {RequestMethod.GET})
    @ResponseBody
    public Result findAll(){
        return Result.success(homeworkService.queryAll());
    }

    /**
     * @discript http://localhost:8084/homework/findAll
     * @param id
     * @return com.cdut.pojo.Homework
     * @author fan
     * @date 2020/7/26 15:50
     */
    @RequestMapping(value = "findById/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public Result findById(@PathVariable("id") String id){
        return Result.success(homeworkService.findById(id));
    }

    /**
     * @discript 删除方法
     * @param id
     * @return int
     * @author fan
     * @date 2020/7/26 16:02
     */
    @RequestMapping(value = "deleteById/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public Result deleteById(@PathVariable("id") String id){
        int status = homeworkService.deleteById(id);
        if (status<=0){
            return Result.failure(ResultCode.HOMEWORK_DELETE_FAILED);
        }else {
            return Result.success();
        }
    }

    /**
     * @discript 数据库插入方法
     * @param
     * @return int
     * @author fan
     * @date 2020/7/26 16:03
     */
    @RequestMapping(value = "insert", method = {RequestMethod.GET})
    @ResponseBody
    public Result insert(){
        Homework homework = new Homework();
        homework.setHomework_id("666");
        homework.setCourse_name("软件体系结构");
        homework.setHomework_content("插入信息");
        homework.setHomework_answer("插入答案");
        int status = homeworkService.insert(homework);
        if (status<=0){
            return Result.failure(ResultCode.HOMEWORK_INSERT_FAILED);
        }else {
            return Result.success();
        }
    }

    /**
     * @discript 数据库更新方法
     * @param id
     * @return int
     * @author fan
     * @date 2020/7/26 16:03
     */
    @RequestMapping(value = "update/{id}", method = {RequestMethod.GET})

    public Result update(@PathVariable("id") int id){
        Homework homework = new Homework();
        homework.setHomework_id("666");
        homework.setCourse_name("update");
        homework.setHomework_answer("update");
        homework.setHomework_content("update");
        int status = homeworkService.update(homework);
        if (status<=0){
            return Result.failure(ResultCode.HOMEWORK_UPDATE_FAILED);
        }else {
            return Result.success();
        }
    }
}
