package com.cdut.pojo;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: Paper
 *   * Author:   healer
 *   * Date:     2020/7/26 11:27
 *   * Description: 试卷试题类
 *  
 */
public class Paper {

    private String paperId;

    private String paperName;

    private String paperDes;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId == null ? null : paperId.trim();
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName == null ? null : paperName.trim();
    }

    public String getPaperDes() {
        return paperDes;
    }

    public void setPaperDes(String paperDes) {
        this.paperDes = paperDes == null ? null : paperDes.trim();
    }
}
