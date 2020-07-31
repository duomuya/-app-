package com.cdut.service;

import com.cdut.pojo.Message;
import com.cdut.pojo.vo.ChatVO;

import java.util.Date;
import java.util.List;

public interface ChatService {
    /** 保存当前消息到消息列表 */
    void addChatMsgToList(ChatVO chatVO, String content, Date date);

    /** 保存消息列表中的消息到数据库中 */
    void saveMessage(List<Message> messages);

    /** 得到对应所有的聊天信息 */
    List<Message> getAllChatMsg(String crId);

}
