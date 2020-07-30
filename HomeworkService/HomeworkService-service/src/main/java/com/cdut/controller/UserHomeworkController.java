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

    /**
     * @discript 根据课程id和批改状态查询学生作业
     * @param cId
     * @param uhStatus
     * @return com.cdut.utils.Result
     * @author fan
     * @date 2020/7/30 10:13
     */
    @RequestMapping(value = "show_stu_homework/{cId}/{uhStatus}", method = {RequestMethod.GET})
    @ResponseBody
    public Result show_stu_homework(@PathVariable("cId") String cId, @PathVariable("uhStatus") Integer uhStatus){
        UserHomework userHomework = new UserHomework();
        userHomework.setHomework_status(uhStatus);
        userHomework.setCourse_id(cId);
        List<UserHomework> list = userHomeworkService.findByRequirement(userHomework);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("stuHomework", list);
        result.put("count", list.size());
        return Result.success(result);
    }

    /**
     * @discript    批改作业 update
     * @param uhId
     * @param uhScore
     * @param uhStatus
     * @return com.cdut.utils.Result
     * @author fan
     * @date 2020/7/30 10:18
     */
    @RequestMapping(value = "correct_homework/{uhId}/{uhScore}/{uhStatus}", method = {RequestMethod.POST})
    @ResponseBody
    public Result correct_homework(@PathVariable("uhId") String uhId, @PathVariable("uhScore") Integer uhScore,
                                   @PathVariable("uhStatus") Integer uhStatus){
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
     * @param uId
     * @param hId
     * @param homeworkUserAnswer
     * @return com.cdut.utils.Result
     * @author fan
     * @date 2020/7/30 12:25
     */
    public Result add_user_homework(String uId, String hId, String homeworkUserAnswer){
        UserHomework userHomework = new UserHomework();
        Date date = new Date();

//        时间戳转时间
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String times = format.format(date.getTime());
//        System.out.println(times);

        userHomework.setUser_id(uId);
        userHomework.setHomework_status(0);
        userHomework.setUh_id(UUID.randomUUID().toString());
        userHomework.setHomework_id(hId);
        userHomework.setHomework_date(new Timestamp(date.getTime()));
        userHomework.setHomework_user_answer(homeworkUserAnswer);
        int status = userHomeworkService.insert(userHomework);
        if (status <= 0) {
            return Result.failure(ResultCode.USERHOMEWORK_INSERT_FAILED);
        } else {
            return Result.success();
        }
    }
}
