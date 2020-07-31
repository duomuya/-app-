package com.cdut.pojo.vo;

import java.io.Serializable;

/**
 * Description: 聊天信息VO
 * Author: cxcxcx
 * Date: 2020/7/29 16:57
 */
public class ChatVO implements Serializable {

    /** 发送者id */
    private String gmFromId;

    /** 发送者昵称 */
    private String gmFromName;

    /** 所属聊天室 */
    private String crId;

    public ChatVO() {
    }

    public ChatVO(String gmFromId, String gmFromName, String crId) {
        this.gmFromId = gmFromId;
        this.gmFromName = gmFromName;
        this.crId = crId;
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

    public String getCrId() {
        return crId;
    }

    public void setCrId(String crId) {
        this.crId = crId;
    }
}
