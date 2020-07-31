package com.cdut.controller;

import com.cdut.client.CourseClient;
import com.cdut.pojo.Exam;
import com.cdut.pojo.Question;
import com.cdut.pojo.StuAnswer;
import com.cdut.pojo.UPaper;
import com.cdut.service.CorrectService;
import com.cdut.service.ExamService;
import com.cdut.service.QuestionService;
import com.cdut.utils.Result;
import com.cdut.utils.ResultCode;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.util.*;

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
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CorrectService correctService;
    @Autowired(required = false)
    private CourseClient courseClient;

    @RequestMapping(value = "show_all_exam", method = RequestMethod.GET)
    @ResponseBody
    public Result showAllByPage(int page, int limit) {
        System.out.println(page + "**" + limit);
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

    @RequestMapping(value = "show_mine_exam", method = RequestMethod.GET)
    @ResponseBody
    public Result showMineExam(String uid) {
        return Result.success(examService.getMineExam(uid));
    }

    @RequestMapping(value = "add_exam", method = RequestMethod.POST)
    @ResponseBody
    public Result addMyExam(@RequestBody Map<String, Object> map) {
        //获取数据
        String examId = UUID.randomUUID().toString();
        String examName = (String) map.get("examName");
        String examDes = (String) map.get("examDes");
        String examStart = (String) map.get("examStart");
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
        String examStart = (String) map.get("examStart");
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


    @RequestMapping(value = "get_courses", method = RequestMethod.GET)
    @ResponseBody
    public Result showCourse(String user_id) {
        System.out.println(user_id);
        System.out.println(courseClient);
        return courseClient.allCoursesByUser(user_id);
    }


    /**
     * 查询学生所有考试信息
     *
     * @return
     */
    @RequestMapping(value = "showExamList/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Result showExamList(@PathVariable("userId") String userId) {
        //通过userID查询选课信息，返回选课课程id列表，根据课程id去exam表查询满足条件的考试
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        JsonElement je = new JsonParser().parse(gson.toJson(courseClient.getCoursesByStudent(userId)));
        List<String> cids = gson.fromJson(je.getAsJsonObject().get("data"), new TypeToken<List<String>>() {
        }.getType());
        return Result.success(examService.showExamList(cids));
    }

    @RequestMapping(value = "showExamDesc/{examId}", method = RequestMethod.GET)
    @ResponseBody
    public Result showExamDesc(@PathVariable("examId") String examId) {
        System.out.println(examService.showExamDes(examId));
        return Result.success(examService.showExamDes(examId));
    }

    @RequestMapping(value = "getPaper/{examId}", method = RequestMethod.GET)
    @ResponseBody
    public String getExamQuestions(@PathVariable("examId") String examId) {
        List<String> choose = new ArrayList<>();
        List<String> fill = new ArrayList<>();
        List<Question> questions = examService.getExamQuestion(examId);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        System.out.println(questions);
        for (Question item : questions) {
            if (item.getqType().equals(1)) {
                choose.add(gson.toJson(item));
            } else if (item.getqType().equals(2)) {
                fill.add(gson.toJson(item));
            }
        }
        System.out.println("{\"choose\":" + choose + ",\"fill\":" + fill + "}");
        return "{\"choose\":" + choose + ",\"fill\":" + fill + "}";
    }


    @RequestMapping(value = "submitPaper", method = RequestMethod.POST)
    @ResponseBody
    public Result submitPaper(@RequestBody Map<String, Object> map) {
        Map map1 = (Map) map.get("answer");
        List<StuAnswer> answers = new ArrayList<>();//用户答题情况列表
        List<Object> objectList = (List<Object>) map1.get("questionList");
        for (Object item : objectList) {
            String qid = (String) ((Map) item).get("qId");
            String myAnswer = (String) ((Map) item).get("qanswer");
            Question question = questionService.selectQuestionById(qid);
            if (myAnswer.equals(question.getqAnswer())){
                //该题正确
                StuAnswer stuAnswer = new StuAnswer();
                stuAnswer.setqId(qid);
                stuAnswer.setqMyAnswer(myAnswer);
                stuAnswer.setqMyScore(question.getqScore());
                stuAnswer.setqAnswer(question.getqAnswer());
                stuAnswer.setqScore(question.getqScore());
                System.out.println("我对了");
                answers.add(stuAnswer);
            } else {
                //该题错误
                StuAnswer stuAnswer = new StuAnswer();
                stuAnswer.setqId(qid);
                stuAnswer.setqMyAnswer(myAnswer);
                stuAnswer.setqMyScore(0);
                stuAnswer.setqAnswer(question.getqAnswer());
                stuAnswer.setqScore(question.getqScore());
                System.out.println("我错了");
                answers.add(stuAnswer);
            }
            System.out.println(question.getqAnswer());//取出答案进行对比
            System.out.println(question.getqScore());//取出分数
            System.out.println(qid+"**"+myAnswer);
        }
//        System.out.println(answers+"!!!!");
        //计算试卷得分
        int score = 0;
        for (StuAnswer answer : answers) {
            score = answer.getqMyScore() + score;
        }
        String submitTime = (String) map1.get("submitTime");//提交时间
        String uid = (String) map1.get("uId");
        String examId = (String) map1.get("examId");
        System.out.println("总得分为"+score);
        Gson gson = new Gson();
        String answerDetail = gson.toJson(answers);
        System.out.println(answerDetail);

        UPaper uPaper = new UPaper();
        String upid = UUID.randomUUID().toString();
        uPaper.setUpId(upid);
        uPaper.setUserId(uid);
        uPaper.setScore(score);
        uPaper.setCommitTime(submitTime);
        uPaper.setCheckStatus(1);
        uPaper.setAnswerDetail(answerDetail);
        uPaper.setExamId(examId);

        //插入操作
        int status = correctService.submitExam(uPaper);
        if (status>=1){
            return Result.success();
        }
        return Result.failure(ResultCode.EXAM_SUBMIT_FAILED);
    }

}
