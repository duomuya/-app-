package com.cdut.pojo;

import java.io.Serializable;

/**
 * Description: 聊天室实体类
 * Author: cxcxcx
 * Date: 2020/7/29 15:25
 */
public class Chatroom implements Serializable {
    /** 聊天室id，与课程表名保持一致 */
    private String crId;

    /** 聊天室名称 */
    private String crName;

    /** 聊天室人数 */
    private Integer crNums;

    /** 聊天室描述 */
    private String crDesc;

    public String getCrId() {
        return crId;
    }

    public void setCrId(String crId) {
        this.crId = crId;
    }

    public String getCrName() {
        return crName;
    }

    public void setCrName(String crName) {
        this.crName = crName;
    }

    public Integer getCrNums() {
        return crNums;
    }

    public void setCrNums(Integer crNums) {
        this.crNums = crNums;
    }

    public String getCrDesc() {
        return crDesc;
    }

    public void setCrDesc(String crDesc) {
        this.crDesc = crDesc;
    }
}
