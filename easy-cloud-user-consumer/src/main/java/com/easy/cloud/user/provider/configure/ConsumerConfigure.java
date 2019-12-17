package com.easy.cloud.user.provider.configure;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 实际开发不使用
 * @author ：Strong
 * @date ：Created in 2019/12/10 15:31
 * @version: 1.0.0
 */
@Configuration
public class ConsumerConfigure {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
