package com.cdut.controller;

import com.cdut.pojo.Homework;
import com.cdut.service.HomeworkService;
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
     * @discript http://localhost:8088/homework/findAll
     *            返回json数据
     * @param
     * @return java.util.List<com.cdut.pojo.Homework>
     * @author fan
     * @date 2020/7/26 15:49
     */
    @RequestMapping(value = "findAll", method = {RequestMethod.GET})
    @ResponseBody
    public List<Homework> findAll(){
        return homeworkService.queryAll();
    }

    /**
     * @discript http://localhost:8086/homework/findAll
     * @param id
     * @return com.cdut.pojo.Homework
     * @author fan
     * @date 2020/7/26 15:50
     */
    @RequestMapping(value = "findById/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public Homework findById(@PathVariable("id") String id){
        return homeworkService.findById(id);
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
    public int deleteById(@PathVariable("id") String id){
        return homeworkService.deleteById(id);
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
    public int insert(){
        Homework homework = new Homework();
        homework.setHomework_id("666");
        homework.setCourse_name("软件体系结构");
        homework.setHomework_content("插入信息");
        homework.setHomework_answer("插入答案");
        return homeworkService.insert(homework);
    }

    /**
     * @discript 数据库更新方法
     * @param id
     * @return int
     * @author fan
     * @date 2020/7/26 16:03
     */
    @RequestMapping(value = "update/{id}", method = {RequestMethod.GET})

    public int update(@PathVariable("id") int id){
        Homework homework = new Homework();
        homework.setHomework_id("666");
        homework.setCourse_name("update");
        homework.setHomework_answer("update");
        homework.setHomework_content("update");
        return homeworkService.update(homework);
    }
}
