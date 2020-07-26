package com.cdut.config;

import com.cdut.pojo.SocketMsg;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/websocket")
@Component
public class MyWebSocket {
    //用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();

    //单聊，用来记录sessionId和该session进行绑定
    private static ConcurrentHashMap<String,Session> map = new ConcurrentHashMap<String, Session>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        //群聊
//        this.session = session;
//        webSocketSet.add(this);     //加入set中
//        System.out.println("有新连接加入！当前在线人数为" + webSocketSet.size());
//        //群发消息，告诉每一位
//        broadcast(session.getId()+"连接上WebSocket-->当前在线人数为："+webSocketSet.size())

        //单聊
        this.session = session;
        map.put(session.getId(),session);

        webSocketSet.add(this);     //加入set中
        System.out.println("有新连接加入:"+session.getId()+"！当前在线人数为" + webSocketSet.size());
        //群发消息，告诉每一位
        broadcast(session.getId()+"连接上WebSocket-->当前在线人数为："+webSocketSet.size());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        System.out.println("有一连接关闭！当前在线人数为" + webSocketSet.size());

        //群发消息，告诉每一位
        broadcast(session.getId()+"下线，当前在线人数为："+webSocketSet.size());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * */
    @OnMessage
    public void onMessage(String message, Session session) {
        //单聊
//        System.out.println("来自客户端的消息:" + message);
//        //群发消息
//        broadcast(message);

        //群聊
        System.out.println("来自客户端的消息:" + session.getId() + ":" + message);

        //从客户端传过来的数据是json数据，所以这里使用jackson进行转换为SocketMsg对象，
        // 然后通过socketMsg的type进行判断是单聊还是群聊，进行相应的处理:
        ObjectMapper objectMapper = new ObjectMapper();
        SocketMsg socketMsg;
        try {
            socketMsg = objectMapper.readValue(message, SocketMsg.class);
            if(socketMsg.getType() == 1){
                //单聊
                socketMsg.setFromUser(session.getId());//发送者.
                Session fromSession = map.get(socketMsg.getFromUser());
                Session toSession = map.get(socketMsg.getToUser());
                if(toSession != null){
                    //发送给发送者和接受者.
                    fromSession.getAsyncRemote().sendText(session.getId()+"："+socketMsg.getMsg());
                    toSession.getAsyncRemote().sendText(session.getId()+"："+socketMsg.getMsg());
                }else{
                    //发送给发送者
                    fromSession.getAsyncRemote().sendText("系统消息：对方已下线");
                }
            }else{
                //群聊
                broadcast(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发生错误时调用
     *
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 群发自定义消息
     * */
    public void broadcast(String message){
        for (MyWebSocket item : webSocketSet) {
            item.session.getAsyncRemote().sendText(message);//异步发送消息.
        }
    }
}
