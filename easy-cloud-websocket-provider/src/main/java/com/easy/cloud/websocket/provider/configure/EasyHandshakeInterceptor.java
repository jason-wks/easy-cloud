package com.easy.cloud.websocket.provider.configure;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * WebSocket拦截器
 * @author ：Strong
 * @date ：Created in 2019/12/12 17:41
 * @version: 1.0.0
 */
@Component
public class EasyHandshakeInterceptor implements HandshakeInterceptor {
    /**
     * 接连前
     * @param request
     * @param response
     * @param handler
     * @param attributes
     * @return
     * @throws Exception
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler, Map<String, Object> attributes) throws Exception {
        attributes.put("uid",1001);
        System.out.println("连接。。。。");
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, @Nullable Exception e) {
        //连接成功获取未读取消息
        System.out.println("连接成功执行");
    }
}
