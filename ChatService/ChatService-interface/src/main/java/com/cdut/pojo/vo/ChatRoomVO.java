package com.cdut.pojo.vo;

import java.io.Serializable;

/**
 * Description: 聊天室VO
 * Author: cxcxcx
 * Date: 2020/7/29 21:11
 */
public class ChatRoomVO implements Serializable {
    /** 传回前端的信息类型 1：消息  2：上下线 */
    private Integer type;

    /** 若是消息，则是消息内容，若是上线下则是对应人数 */
    private Object msg;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }
}
