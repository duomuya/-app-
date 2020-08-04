package com.cdut.controller;

import com.cdut.pojo.UserHomework;
import com.cdut.service.UserHomeworkService;
import com.cdut.utils.Result;
import com.cdut.utils.ResultCode;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author fan
 * @package com.cdut.controller
 * @date 2020/7/29 16:49
 */
@RestController
@RequestMapping("userHomework")
public class UserHomeworkController {

    @Autowired
    private UserHomeworkService userHomeworkService;

    //测试方法
    @RequestMapping(value = "hello")
    public String hello(){
        return "hello";
    }

    /**
     * @discript 根据课程id和批改状态查询学生作业
     * @param cId
     * @param uhStatus
     * @return com.cdut.utils.Result
     * @author fan
     * @date 2020/7/30 10:13
     */
    @RequestMapping(value = "show_stu_homework", method = {RequestMethod.GET})
    @ResponseBody
    public Result show_stu_homework(Integer page, Integer limit, String cId, Integer uhStatus, String uId){
        System.out.println("||"+page+"||"+limit+"||"+cId+"||"+uhStatus+"||"+uId);
        UserHomework userHomework = new UserHomework();
        userHomework.setHomework_status(uhStatus);
        userHomework.setCourse_id(cId);
        List<UserHomework> list = null;
        int count = 0;
        if (cId!=null && cId!=""){
            list = userHomeworkService.findByRequirementByCourse((page-1)*limit, limit, cId, uhStatus, uId);
            count = userHomeworkService.getCountByCourse(cId, uhStatus);
        }else {
            list = userHomeworkService.findByRequirementByTeacher((page-1)*limit, limit, uId, uhStatus);
            count = userHomeworkService.getCountByTeacher(uId, uhStatus);
        }
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("stuHomework", list);
        result.put("count", count);
        return Result.success(result);
    }

    /**
     * @discript    批改作业 update
     * @param map
     * @return com.cdut.utils.Result
     * @author fan
     * @date 2020/7/30 10:18
     */
    @RequestMapping(value = "correct_homework", method = {RequestMethod.POST})
    @ResponseBody
    public Result correct_homework(@RequestBody Map<String, Object> map){
        Integer uhStatus = (Integer) map.get("uhStatus");
        Integer uhScore = (Integer) map.get("uhScore");
        String uhId = (String) map.get("uhId");

        UserHomework userHomework = new UserHomework();
        userHomework.setHomework_status(uhStatus);
        userHomework.setHomework_score(uhScore);
        userHomework.setUh_id(uhId);
        int status = userHomeworkService.update(userHomework);
        if (status <= 0) {
            return Result.failure(ResultCode.USERHOMEWORK_UPDATE_FAILED);
        } else {
            return Result.success();
        }
    }

    /**
     * @discript 提交作业
     * @param map
     * @return com.cdut.utils.Result
     * @author fan
     * @date 2020/7/30 12:25
     */
    @RequestMapping(value = "add_user_homework", method = {RequestMethod.POST})
    @ResponseBody
    public Result add_user_homework(@RequestBody Map<String, Object> map){
        String uId = (String) map.get("uId");
        String hId = (String) map.get("hId");
        String homeworkUserAnswer = (String) map.get("homeworkUserAnswer");

        UserHomework userHomework = new UserHomework();
        Date date = new Date();

//        时间戳转时间
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String times = format.format(date.getTime());
//        System.out.println(times);

        userHomework.setUh_id(UUID.randomUUID().toString());
        userHomework.setUser_id(uId);
        userHomework.setHomework_id(hId);
        userHomework.setHomework_score(-1);
        userHomework.setHomework_user_answer(homeworkUserAnswer);
        userHomework.setHomework_status(0);
        userHomework.setHomework_date(new Timestamp(date.getTime()));

        int status = userHomeworkService.insert(userHomework);
        if (status <= 0) {
            return Result.failure(ResultCode.USERHOMEWORK_INSERT_FAILED);
        } else {
            return Result.success();
        }
    }

//    @Test
//    public void test(){
//        Date date = new Date();
//        System.out.println(new Timestamp(date.getTime()));
//    }
}
