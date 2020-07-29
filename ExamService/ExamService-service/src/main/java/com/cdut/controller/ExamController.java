package com.cdut.controller;

import com.cdut.pojo.Exam;
import com.cdut.service.ExamService;
import com.cdut.utils.Result;
import com.cdut.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: ExamController
 *   * Author:   healer
 *   * Date:     2020/7/26 11:38
 *   * Description: 考试信息controller
 *  
 */
@RestController
@RequestMapping("exam")
public class ExamController {
    @Autowired
    private ExamService examService;

    @RequestMapping(value = "show_all_exam", method = RequestMethod.GET)
    @ResponseBody
    public Result showAllByPage(int page, int limit) {
        System.out.println(page+"**"+limit);
        List<Exam> exams = examService.getByPage(page, limit);
        int count = examService.getAllCount();
        Object[] object = {exams, count};
        return Result.success(object);
    }

    @RequestMapping(value = "show_my_exam", method = RequestMethod.GET)
    @ResponseBody
    public Result showMineByPage(String id, int page, int limit) {
        List<Exam> exams = examService.getByUserId(id, page, limit);
        int count = examService.getCountById(id);
        Object[] object = {exams, count};
        return Result.success(object);
    }

    @RequestMapping(value = "add_exam", method = RequestMethod.POST)
    @ResponseBody
    public Result addMyExam(@RequestBody Map<String, Object> map) {
        //获取数据
        String examId = UUID.randomUUID().toString();
        String examName = (String) map.get("examName");
        String examDes = (String) map.get("examDes");
        Date examStart = (Date) map.get("examStart");
        Integer examLast = (Integer) map.get("examLast");
        Integer examNumber = (Integer) map.get("examNumber");
        String examCourse = (String) map.get("examCourse");
        String paperId = (String) map.get("paperId");
        String userId = (String) map.get("userId");
        //封装
        Exam exam = new Exam();
        exam.setExamId(examId);
        exam.setExamName(examName);
        exam.setExamDes(examDes);
        exam.setExamStart(examStart);
        exam.setExamLast(examLast);
        exam.setExamNumber(examNumber);
        exam.setExamCourse(examCourse);
        exam.setPaperId(paperId);
        exam.setUserId(userId);

        int status = examService.addExam(exam);
        if (status <= 0) {
            return Result.failure(ResultCode.EXAM_ADD_FAILED);
        } else {
            return Result.success();
        }
    }

    @RequestMapping(value = "update_exam", method = RequestMethod.POST)
    @ResponseBody
    public Result updateExam(@RequestBody Map<String, Object> map) {
        String examName = (String) map.get("examName");
        String examDes = (String) map.get("examDes");
        Date examStart = (Date) map.get("examStart");
        Integer examLast = (Integer) map.get("examLast");
        Integer examNumber = (Integer) map.get("examNumber");
        String examCourse = (String) map.get("examCourse");
        String paperId = (String) map.get("paperId");
        //封装
        Exam exam = new Exam();
        exam.setExamName(examName);
        exam.setExamDes(examDes);
        exam.setExamStart(examStart);
        exam.setExamLast(examLast);
        exam.setExamNumber(examNumber);
        exam.setExamCourse(examCourse);
        exam.setPaperId(paperId);

        int status = examService.updateExam(exam);
        if (status <= 0) {
            return Result.failure(ResultCode.EXAM_UPDATE_FAILED);
        } else {
            return Result.success();
        }
    }

    @RequestMapping(value = "/delete_exam", method = RequestMethod.GET)
    @ResponseBody
    public Result deleteExam(String id) {
        int status = examService.deleteExamById(id);
        if (status <= 0) {
            return Result.failure(ResultCode.EXAM_DELETE_FAILED);
        } else {
            return Result.success();
        }
    }

    @RequestMapping(value = "/batch_delete_exam", method = RequestMethod.POST)
    @ResponseBody
    public Result batchDeleteExam(@RequestBody Map<String, Object> map) {
        List<String> ids = (List<String>) map.get("delList");

        int status = examService.batchDeleteExamById(ids);
        if (status == ids.size()) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.EXAM_BATCH_DELETE_FAILED);
        }
    }
}
