package com.cdut.task;

import com.cdut.pojo.Message;
import com.cdut.service.ChatService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Description: 定时任务类
 * Author: cxcxcx
 * Date: 2020/7/29 16:22
 */
@Component
public class SchedulerTask {
    /** 使用线程安全的容器来保存信息 */
    public static List<Message> messages = Collections.synchronizedList(new ArrayList<>());

    @Autowired
    private ChatService chatService;

    /**
     * 上一次执行完毕后的每分钟再次执行定时任务
     */
    @Scheduled(fixedDelay = 60*1000)
    public void saveMessages(){
        if (messages.size() > 0){
            System.out.println("定时任务");
            System.out.println("size: " + messages.size());
            chatService.saveMessage(messages);
            SchedulerTask.messages.clear();
        }
    }

}
