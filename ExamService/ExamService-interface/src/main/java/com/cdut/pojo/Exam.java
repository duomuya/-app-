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

    private String examStart;

    private String examCourse;

    private String paperId;

    private String userId;

    private String courseName;

    private String paperName;

    private Integer scoreAll;
    private Integer qNumber;

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

    public String getExamStart() {
        return examStart;
    }

    public void setExamStart(String examStart) {
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public Integer getScoreAll() {
        return scoreAll;
    }

    public void setScoreAll(Integer scoreAll) {
        this.scoreAll = scoreAll;
    }

    public Integer getqNumber() {
        return qNumber;
    }

    public void setqNumber(Integer qNumber) {
        this.qNumber = qNumber;
    }
}
