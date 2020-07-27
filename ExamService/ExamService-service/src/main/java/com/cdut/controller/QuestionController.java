package com.cdut.controller;

import com.cdut.pojo.Question;
import com.cdut.service.QuestionService;
import com.cdut.utils.Result;
import com.cdut.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: QuestionController
 *   * Author:   healer
 *   * Date:     2020/7/26 11:46
 *   * Description: 试题信息controller
 *  
 */
@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "show_all_question", method = RequestMethod.GET)
    @ResponseBody
    public Result showAll() {
        List<Question> questions = questionService.queryAll();
        return Result.success(questions);
    }

    @RequestMapping(value = "show_by_page", method = RequestMethod.GET)
    @ResponseBody
    public Result showByPage(int page, int limit) {
        return Result.success();
    }

    @RequestMapping(value = "add_question", method = RequestMethod.POST)
    @ResponseBody
    public Result addQuestion(@RequestBody Map<String, Object> map) {
        //获取数据
        String qId = UUID.randomUUID().toString();
        String qContent = (String) map.get("qContent");
        String qAnswer = (String) map.get("qAnswer");
        Integer qScore = (Integer) map.get("qScore");
        String qA = (String) map.get("qA");
        String qB = (String) map.get("qB");
        String qC = (String) map.get("qC");
        String qD = (String) map.get("qD");
        //封装
        Question question = new Question();
        question.setqId(qId);
        question.setqContent(qContent);
        question.setqAnswer(qAnswer);
        question.setqScore(qScore);
        question.setqA(qA);
        question.setqB(qB);
        question.setqC(qC);
        question.setqD(qD);

        int status = questionService.addQuestion(question);
        if (status <= 0) {
            return Result.failure(ResultCode.QUESTION_ADD_FAILED);
        } else {
            return Result.success();
        }
    }

    @RequestMapping(value = "update_question", method = RequestMethod.POST)
    @ResponseBody
    public Result updateQuestion(@RequestBody Map<String, Object> map) {
        //获取数据
        String qId = (String) map.get("qId");
        String qContent = (String) map.get("qContent");
        String qAnswer = (String) map.get("qAnswer");
        Integer qScore = (Integer) map.get("qScore");
        String qA = (String) map.get("qA");
        String qB = (String) map.get("qB");
        String qC = (String) map.get("qC");
        String qD = (String) map.get("qD");
        //封装
        Question question = new Question();
        question.setqId(qId);
        question.setqContent(qContent);
        question.setqAnswer(qAnswer);
        question.setqScore(qScore);
        question.setqA(qA);
        question.setqB(qB);
        question.setqC(qC);
        question.setqD(qD);

        int status = questionService.updateQuestionById(question);
        if (status <= 0) {
            return Result.failure(ResultCode.QUESTION_UPDATE_FAILED);
        } else {
            return Result.success();
        }
    }

    @RequestMapping(value = "delete_question", method = RequestMethod.GET)
    @ResponseBody
    public Result deleteQuestion(String id) {
        int status = questionService.deleteQuestion(id);
        if (status <= 0) {
            return Result.failure(ResultCode.QUESTION_DELETE_FAILED);
        } else {
            return Result.success();
        }
    }

    @RequestMapping(value = "/batch_delete_question", method = RequestMethod.POST)
    @ResponseBody
    public Result batchDeletequestion(@RequestBody Map<String, Object> map) {
        List<String> ids = (List<String>) map.get("delList");

        int status = questionService.batchDeleteQuestion(ids);
        if (status == ids.size()) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.QUESTION_BATCH_DELETE_FAILED);
        }
    }
}
