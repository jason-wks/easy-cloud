package com.easy.cloud.cache.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ：Strong
 * @date ：Created in 2019/12/12 10:04
 * @version: 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CacheProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(CacheProviderApplication.class,args);
    }
}
