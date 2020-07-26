package com.cdut.pojo;

import java.io.Serializable;

/**
 * Description: 消息对象
 * Author: cxcxcx
 * Date: 2020/7/26 19:45
 */
public class SocketMsg implements Serializable {
    private int type;  //聊天类型0：群聊，1：单聊
    private String fromUser;  //发送者
    private String toUser;  //接收者
    private String msg;  //发送的消息

    public SocketMsg() {
    }

    public SocketMsg(int type, String fromUser, String toUser, String msg) {
        this.type = type;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.msg = msg;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
