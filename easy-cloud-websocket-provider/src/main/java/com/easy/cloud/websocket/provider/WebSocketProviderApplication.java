package com.easy.cloud.websocket.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author ：Strong
 * @date ：Created in 2019/12/12 12:38
 * @version: 1.0.0
 */
@SpringBootApplication
public class WebSocketProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebSocketProviderApplication.class,args);
    }
}
