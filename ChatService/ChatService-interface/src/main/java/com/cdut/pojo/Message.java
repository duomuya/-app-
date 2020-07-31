package com.cdut.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Description: 聊天消息实体类
 * Author: cxcxcx
 * Date: 2020/7/29 15:26
 */
public class Message implements Serializable {
    /** 消息id */
    private String gmId;

    /** 消息内容 */
    private String gmContent;

    /** 发送者id */
    private String gmFromId;

    /** 发送者昵称 */
    private String gmFromName;

    /** 消息发送时间 */
    private Date gmCreatetime;

    /** 所属聊天室 */
    private String crId;

    public String getGmId() {
        return gmId;
    }

    public void setGmId(String gmId) {
        this.gmId = gmId;
    }

    public String getGmContent() {
        return gmContent;
    }

    public void setGmContent(String gmContent) {
        this.gmContent = gmContent;
    }

    public String getGmFromId() {
        return gmFromId;
    }

    public void setGmFromId(String gmFromId) {
        this.gmFromId = gmFromId;
    }

    public String getGmFromName() {
        return gmFromName;
    }

    public void setGmFromName(String gmFromName) {
        this.gmFromName = gmFromName;
    }

    public Date getGmCreatetime() {
        return gmCreatetime;
    }

    public void setGmCreatetime(Date gmCreatetime) {
        this.gmCreatetime = gmCreatetime;
    }

    public String getCrId() {
        return crId;
    }

    public void setCrId(String crId) {
        this.crId = crId;
    }
}
