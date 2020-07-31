package com.cdut.pojo;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: Question
 *   * Author:   healer
 *   * Date:     2020/7/26 11:28
 *   * Description: 试题实体类
 *  
 */
public class Question {

    private String qId;

    private String qContent;

    private String qAnswer;

    private Integer qScore;

    private String qA;

    private String qB;

    private String qC;

    private String qD;

    private Integer qType;

    public Integer getqType() {
        return qType;
    }

    public void setqType(Integer qType) {
        this.qType = qType;
    }

    public String getqId() {
        return qId;
    }

    public void setqId(String qId) {
        this.qId = qId == null ? null : qId.trim();
    }

    public String getqContent() {
        return qContent;
    }

    public void setqContent(String qContent) {
        this.qContent = qContent == null ? null : qContent.trim();
    }

    public String getqAnswer() {
        return qAnswer;
    }

    public void setqAnswer(String qAnswer) {
        this.qAnswer = qAnswer == null ? null : qAnswer.trim();
    }

    public Integer getqScore() {
        return qScore;
    }

    public void setqScore(Integer qScore) {
        this.qScore = qScore;
    }

    public String getqA() {
        return qA;
    }

    public void setqA(String qA) {
        this.qA = qA == null ? null : qA.trim();
    }

    public String getqB() {
        return qB;
    }

    public void setqB(String qB) {
        this.qB = qB == null ? null : qB.trim();
    }

    public String getqC() {
        return qC;
    }

    public void setqC(String qC) {
        this.qC = qC == null ? null : qC.trim();
    }

    public String getqD() {
        return qD;
    }

    public void setqD(String qD) {
        this.qD = qD == null ? null : qD.trim();
    }
}
