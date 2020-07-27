package com.cdut.pojo;

import java.util.Date;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: Exam
 *   * Author:   healer
 *   * Date:     2020/7/26 11:27
 *   * Description: 考试信息试题类
 *  
 */
public class Exam {

    private String examId;

    private String examName;

    private String examDes;

    private Integer examLast;

    private Integer examNumber;

    private Date examStart;

    private String examCourse;

    private String paperId;

    private String userId;

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName == null ? null : examName.trim();
    }

    public String getExamDes() {
        return examDes;
    }

    public void setExamDes(String examDes) {
        this.examDes = examDes;
    }

    public Integer getExamLast() {
        return examLast;
    }

    public void setExamLast(Integer examLast) {
        this.examLast = examLast;
    }

    public Integer getExamNumber() {
        return examNumber;
    }

    public void setExamNumber(Integer examNumber) {
        this.examNumber = examNumber;
    }

    public Date getExamStart() {
        return examStart;
    }

    public void setExamStart(Date examStart) {
        this.examStart = examStart;
    }

    public String getExamCourse() {
        return examCourse;
    }

    public void setExamCourse(String examCourse) {
        this.examCourse = examCourse == null ? null : examCourse.trim();
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId == null ? null : paperId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}
