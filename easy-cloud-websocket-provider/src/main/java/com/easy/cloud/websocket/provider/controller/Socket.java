package com.easy.cloud.websocket.provider.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ：Strong
 * @date ：Created in 2019/12/12 12:39
 * @version: 1.0.0
 */
@Slf4j
@Controller
@ServerEndpoint("/webSocket")
public class Socket {
    //websocket 客户端会话Session 向客户端发送数据
    private Session session;

    //线程安全set，存放每个客户端处理消息的对象
    private static CopyOnWriteArrayList<Socket> webSocketSet = new CopyOnWriteArrayList<>();

    //建立连接成功后调用
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSocketSet.add(this);
        log.info("==========>online session : {}",webSocketSet.size());
    }

    //连接关闭调用
    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
    }

    @OnMessage
    public void onMessage(String message) throws IOException{
        this.sendMessage("server send message : "+ message);
    }

    @OnError
    public void onError(Session session,Throwable error){
        error.printStackTrace();
    }

    public void sendMessage(String message) throws IOException {
        for (Socket socket : webSocketSet) {
            socket.session.getBasicRemote().sendText(message);
        }
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
