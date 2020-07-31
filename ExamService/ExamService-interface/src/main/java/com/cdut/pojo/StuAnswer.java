package com.cdut.pojo;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: StuAnswer
 *   * Author:   healer
 *   * Date:     2020/7/26 11:28
 *   * Description: 学生答题信息试题类
 *  
 */
public class StuAnswer {
    private String qId;
    private String qMyAnswer;
    private String qAnswer;
    private int qScore;
    private int qMyScore;

    public String getqId() {
        return qId;
    }

    public void setqId(String qId) {
        this.qId = qId;
    }

    public String getqAnswer() {
        return qAnswer;
    }

    public void setqAnswer(String qAnswer) {
        this.qAnswer = qAnswer;
    }

    public int getqScore() {
        return qScore;
    }

    public void setqScore(int qScore) {
        this.qScore = qScore;
    }

    public String getqMyAnswer() {
        return qMyAnswer;
    }

    public void setqMyAnswer(String qMyAnswer) {
        this.qMyAnswer = qMyAnswer;
    }

    public int getqMyScore() {
        return qMyScore;
    }

    public void setqMyScore(int qMyScore) {
        this.qMyScore = qMyScore;
    }
}
