package com.cdut.controller;

import com.cdut.pojo.Homework;
import com.cdut.service.HomeworkService;
import com.cdut.utils.Result;
import com.cdut.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.sql.Date;

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
     * @discript 根据用户（老师）id查作业
     * @param uId
     * @return com.cdut.utils.Result
     * @author fan
     * @date 2020/7/29 16:35
     */
    @RequestMapping(value = "show_mine_homework/{uId}", method = {RequestMethod.GET})
    @ResponseBody
    public Result show_mine_homework(@PathVariable("uId") String uId){
        List<Homework> list = homeworkService.findByTeacherId(uId);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("homework", list);
        result.put("count", list.size());
        return Result.success(list);
    }

    /**
     * @discript 删除作业
     * @param hId
     * @return int
     * @author fan
     * @date 2020/7/26 16:02
     */
    @RequestMapping(value = "delete_homework/{hId}", method = {RequestMethod.GET})
    @ResponseBody
    public Result delete_homework(@PathVariable("hId") String hId){
        int status = homeworkService.deleteById(hId);
        if (status<=0){
            return Result.failure(ResultCode.HOMEWORK_DELETE_FAILED);
        }else {
            return Result.success();
        }
    }

    /**
     * @discript 批量删除
     * @param delist
     * @return com.cdut.utils.Result
     * @author fan
     * @date 2020/7/29 15:29
     */
    @RequestMapping(value = "delete_homework/{delist}", method = {RequestMethod.POST})
    @ResponseBody
    public Result batch_delete_homework(@PathVariable("delist") List<String> delist){
        for (String hId:delist) {
            int status = homeworkService.deleteById(hId);
            if (status<=0){
                return Result.failure(ResultCode.HOMEWORK_DELETE_FAILED);
            }
        }
        return Result.success();
    }

    /**
     * @discript 作业添加
     * @param
     * @return int
     * @author fan
     * @date 2020/7/26 16:03
     */
    @RequestMapping(value = "add_homework", method = {RequestMethod.POST})
    @ResponseBody
    public Result add_homework(String hContent, String hAnswer, String cId, String uId, Date uhDeadline){
        Homework homework = new Homework();
        String homework_id = UUID.randomUUID().toString();
        homework.setHomework_id(homework_id);
        homework.setHomework_answer(hAnswer);
        homework.setHomework_content(hContent);
        homework.setCourse_id(cId);
        homework.setHomework_deadline(uhDeadline);
        homework.setTeacher_id(uId);
        int status = homeworkService.insert(homework);
        if (status<=0){
            return Result.failure(ResultCode.HOMEWORK_INSERT_FAILED);
        }else {
            return Result.success();
        }
    }

    /**
     * @discript 作业编辑
     * @param hId
     * @param hContent
     * @param hAnswer
     * @param cId
     * @param uId
     * @param uhDeadline
     * @return com.cdut.utils.Result
     * @author fan
     * @date 2020/7/29 15:21
     */
    @RequestMapping(value = "update_homework/{hId}/{hContent}/{hAnswer}/{cId}/{uId}/{uhDeadline}", method = {RequestMethod.POST})
    @ResponseBody
    public Result update_homework(@PathVariable("hId") String hId, @PathVariable("hContent") String hContent,
                         @PathVariable("hAnswer") String hAnswer, @PathVariable("cId") String cId,
                         @PathVariable("uId") String uId, @PathVariable("uhDeadline") Date uhDeadline) {
        Homework homework = new Homework();
        homework.setHomework_id(hId);
        homework.setTeacher_id(uId);
        homework.setHomework_deadline(uhDeadline);
        homework.setCourse_id(cId);
        homework.setHomework_content(hContent);
        homework.setHomework_answer(hAnswer);
        int status = homeworkService.update(homework);
        if (status <= 0) {
            return Result.failure(ResultCode.HOMEWORK_UPDATE_FAILED);
        } else {
            return Result.success();
        }
    }

    //联合查询
//    public List<UserHomework> show_stu_homework(String cId, Integer uhStatus);//query
    /**
     * @discript  根据条件作业答题查询（用户作业表）
     * @param cId
     * @param uhStatus
     * @return com.cdut.utils.Result
     * @author fan
     * @date 2020/7/29 16:34
     */
//    public Result show_stu_homework(String cId, Integer uhStatus){
//        return null;
//    }
//    public int correct_homework(String uhId, Integer uhScore, Integer  uhStatus);//update
}
