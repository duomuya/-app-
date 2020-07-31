package com.cdut.service.impl;

import com.cdut.mapper.ChatMapper;
import com.cdut.pojo.Message;
import com.cdut.pojo.vo.ChatVO;
import com.cdut.service.ChatService;
import com.cdut.task.SchedulerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;

@Service
@Transactional
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatMapper chatMapper;

    @Autowired
    SchedulerTask schedulerTask;

    @Override
    public void addChatMsgToList(ChatVO chatVO, String content, Date date) {
        Message message = new Message();
        String gmID = UUID.randomUUID().toString();
        message.setGmId(gmID);  //设置当前消息id
        message.setGmContent(content);  //设置当前消息内容
        message.setGmFromId(chatVO.getGmFromId());  //设置当前消息发送者id
        message.setGmFromName(chatVO.getGmFromName());  //设置当前消息发送者昵称
        message.setGmCreatetime(date);  //设置当前消息发送时间
        message.setCrId(chatVO.getCrId());  //设置当前消息所属聊天室
        System.out.println("UUID：" + gmID);
        SchedulerTask.messages.add(message);   //添加任务到消息列表

    }

    @Override
    public void saveMessage(List<Message> messages) {
        chatMapper.saveMessage(messages);
    }

    @Override
    public List<Message> getAllChatMsg(String crId) {
        return chatMapper.getAllChatMsg(crId);
    }


}
