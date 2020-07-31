package com.cdut.mapper;

import com.cdut.pojo.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChatMapper {

    void saveMessage(@Param("messages") List<Message> messages);

    List<Message> getAllChatMsg(String crId);
}
