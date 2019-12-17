package com.easy.cloud.websocket.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author ：Strong
 * @date ：Created in 2019/12/12 14:41
 * @version: 1.0.0
 */
@RestController
@RequestMapping("socket")
public class WebSocketController {
    @Autowired
    private Socket socket;
    @GetMapping("/{message}")
    public void sendMessage(@PathVariable("message") String message) throws IOException {
        socket.sendMessage("这个是controller 发送的消息："+message);
    }
}
