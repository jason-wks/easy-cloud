package com.easy.cloud.websocket.provider.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


/**
 *
 * @author ：Strong
 * @date ：Created in 2019/12/12 12:40
 * @version: 1.0.0
 */
@Configuration
@EnableConfigurationProperties(WebSocketProperties.class)
@ConditionalOnClass({WebSocketProperties.class,EasyWebSocketHandler.class,EasyHandshakeInterceptor.class})
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer{
    private final WebSocketProperties webSocketProperties;

    @Autowired private EasyWebSocketHandler easyWebSocketHandler;
    @Autowired private EasyHandshakeInterceptor easyHandshakeInterceptor;

    public WebSocketConfiguration(WebSocketProperties webSocketProperties) {
        this.webSocketProperties = webSocketProperties;
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(easyWebSocketHandler,webSocketProperties.getEndpoint())
                .setAllowedOrigins(webSocketProperties.getAllowedOrigins())
                .addInterceptors(easyHandshakeInterceptor);
    }
}
