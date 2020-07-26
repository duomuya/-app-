package com.cdut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
