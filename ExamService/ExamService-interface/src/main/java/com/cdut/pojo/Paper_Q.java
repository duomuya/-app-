package com.cdut.pojo;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: Paper_Q
 *   * Author:   healer
 *   * Date:     2020/7/31 12:03
 *   * Description:
 *  
 */
public class Paper_Q {
    private String pqId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Paper_Q.paper_id
     *
     * @mbg.generated
     */
    private String paperId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Paper_Q.question_id
     *
     * @mbg.generated
     */
    private String questionId;

    public String getPqId() {
        return pqId;
    }

    public void setPqId(String pqId) {
        this.pqId = pqId == null ? null : pqId.trim();
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId == null ? null : paperId.trim();
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
    }
}