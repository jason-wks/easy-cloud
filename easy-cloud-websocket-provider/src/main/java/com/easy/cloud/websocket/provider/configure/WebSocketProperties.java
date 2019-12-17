package com.easy.cloud.websocket.provider.configure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ：Strong
 * @date ：Created in 2019/12/12 12:42
 * @version: 1.0.0
 */
@Data
@ConfigurationProperties(prefix = "spring.web.socket")
public class WebSocketProperties {
    private String endpoint = "/socket";
    private String allowedOrigins = "*";
    private String prefix = "/server";
}
