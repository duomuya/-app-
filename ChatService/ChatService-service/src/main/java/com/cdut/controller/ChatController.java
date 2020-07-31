package com.cdut.controller;

import com.cdut.pojo.Message;
import com.cdut.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/chatMsg/{crId}")
    public List<Message> getAllChatMsg(@PathVariable("crId") String crId){
        return chatService.getAllChatMsg(crId);
    }
}
