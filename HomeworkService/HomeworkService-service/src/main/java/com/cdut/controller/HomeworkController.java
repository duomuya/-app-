package com.cdut.controller;

import com.cdut.pojo.Homework;
import com.cdut.service.HomeworkService;
import com.cdut.utils.Result;
import com.cdut.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
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

    @RequestMapping(value = "findByCourseId/{cId}", method = {RequestMethod.GET})
    @ResponseBody
    public Result findByCourseId(@PathVariable("cId") String cId){
        return Result.success(homeworkService.findByCourseId(cId));
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
    @RequestMapping(value = "show_mine_homework", method = {RequestMethod.GET})
    @ResponseBody
    public Result show_mine_homework(Integer page, Integer limit, String uId){
        List<Homework> list = homeworkService.findByTeacherId(uId, (page-1)*limit, limit);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("homework", list);
        int count = homeworkService.getCount(uId);
        result.put("count", count);
        return Result.success(result);
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
     * @param map
     * @return com.cdut.utils.Result
     * @author fan
     * @date 2020/7/29 15:29
     */
    @RequestMapping(value = "batch_delete_homework", method = {RequestMethod.POST})
    @ResponseBody
    public Result batch_delete_homework(@RequestBody Map<String, Object> map){
        List<String> delist = (List<String>)map.get("delist");
//        @PathVariable("delist") List<String> delist
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
    public Result add_homework(@RequestBody Map<String, Object> map){
//        @PathVariable("hContent") String hContent,
//                               @PathVariable("hAnswer") String hAnswer,
//                               @PathVariable("cId")String cId,
//                               @PathVariable("uId")String uId,
//                               @PathVariable("uhDeadline")Date uhDeadline
        String hAnswer = (String)map.get("hAnswer");
        String hContent = (String)map.get("hContent");
        String cId = (String)map.get("cId");
        String uId = (String)map.get("uId");
        String date = (String) map.get("uhDeadline");

        Date uhDeadline = strToDate(date);

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
     * @param map
     * @return com.cdut.utils.Result
     * @author fan
     * @date 2020/7/29 15:21
     */
    @RequestMapping(value = "update_homework", method = {RequestMethod.POST})
    @ResponseBody
    public Result update_homework(@RequestBody Map<String, Object> map) {
        String hId = (String) map.get("hId");
        String uId = (String) map.get("uId");
        String cId = (String) map.get("cId");
        String hContent = (String) map.get("hContent");
        String hAnswer = (String) map.get("hAnswer");
        String date = (String) map.get("hDeadline");

        Date uhDeadline = strToDate(date);

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


    public static java.sql.Date strToDate(String strDate) {
        String str = strDate;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;
        try {
            d = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Date date = new java.sql.Date(d.getTime());
        return date;
    }
}
