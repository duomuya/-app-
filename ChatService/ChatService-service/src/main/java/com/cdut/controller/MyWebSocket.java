package com.cdut.controller;

import com.alibaba.fastjson.JSON;
import com.cdut.pojo.vo.ChatRoomVO;
import com.cdut.pojo.vo.ChatVO;
import com.cdut.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/websocket/{crId}/{gmFromId}/{gmFromName}")
@Component
public class MyWebSocket {
    //用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    private static ChatService chatService;

    private ChatVO chatVO;  //聊天请求VO

    private ChatRoomVO chatRoomVO;  //聊天室信息VO

    // 注入的时候，给类的 service 注入
    @Autowired
    public void setChatService(ChatService chatService) {
        MyWebSocket.chatService = chatService;
    }

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("crId") String crId
                                      , @PathParam("gmFromId") String gmFromId
                                      , @PathParam("gmFromName") String gmFromName) {
        this.session = session;
        this.chatVO = new ChatVO(gmFromId, gmFromName, crId);  //将请求信息保存到VO中
        webSocketSet.add(this);     //加入set中
        System.out.println("有新连接加入！当前在线人数为" + webSocketSet.size());
        chatRoomVO = new ChatRoomVO();
        chatRoomVO.setType(2);
        chatRoomVO.setMsg(webSocketSet.size());
        //群发消息，告诉每一位
        broadcast(chatRoomVO, 2);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        System.out.println("有一连接关闭！当前在线人数为" + webSocketSet.size());
        //群发消息，告诉每一位
        chatRoomVO = new ChatRoomVO();
        chatRoomVO.setType(2);
        chatRoomVO.setMsg(webSocketSet.size());
        broadcast(chatRoomVO, 2);
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * */
    @OnMessage
    public void onMessage(String message) {
        //群聊
        System.out.println("来自客户端的消息:" + message);
        chatService.addChatMsgToList(this.chatVO, message, new Date());  //保存聊天信息到列表中
        //群发消息
        chatRoomVO = new ChatRoomVO();
        chatRoomVO.setType(1);
        chatRoomVO.setMsg(message);
        broadcast(chatRoomVO, 1);
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 群发自定义消息
     * */
    private void broadcast(ChatRoomVO chatRoomVO, int type){
        for (MyWebSocket item : webSocketSet) {
            if (type == 2){   //如果是上下线，所有人都要接收
                item.session.getAsyncRemote().sendText(JSON.toJSONString(chatRoomVO));  //给其他人发送异步发送消息
            }else if (item != this){  //如果是发送信息，自己不接收
                item.session.getAsyncRemote().sendText(JSON.toJSONString(chatRoomVO));  //给其他人发送异步发送消息
            }
        }
    }
}
