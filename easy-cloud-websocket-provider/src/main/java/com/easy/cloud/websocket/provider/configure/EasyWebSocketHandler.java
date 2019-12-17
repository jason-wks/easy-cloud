package com.easy.cloud.websocket.provider.configure;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @author ：Strong
 * @date ：Created in 2019/12/12 17:05
 * @version: 1.0.0
 */
@Component
public class EasyWebSocketHandler extends TextWebSocketHandler {
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("获取到的消息：" + message.getPayload());

        //给客户端发送消息
        session.sendMessage(new TextMessage("消息已收到"));

        if ("10".equals(message.getPayload())){
            for (int i = 0;i < 10;i++) {
                session.sendMessage(new TextMessage("消息 ->" + i));
                Thread.sleep(100);
            }
        }
    }

    //连接
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String uid = String.valueOf( session.getAttributes().get("uid"));
        session.sendMessage(new TextMessage(uid + ", 欢迎连接easy"));
    }

    //断开连接
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("连接断开");
    }
}
