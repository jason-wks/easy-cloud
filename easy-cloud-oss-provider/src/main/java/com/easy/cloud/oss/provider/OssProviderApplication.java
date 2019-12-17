package com.easy.cloud.oss.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ：Strong
 * @date ：Created in 2019/12/11 16:37
 * @version: 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OssProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssProviderApplication.class,args);
    }
}
