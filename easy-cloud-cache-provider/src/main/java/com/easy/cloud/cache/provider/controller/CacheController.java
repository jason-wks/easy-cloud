package com.easy.cloud.cache.provider.controller;

import com.alibaba.nacos.client.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author ：Strong
 * @date ：Created in 2019/12/12 10:16
 * @version: 1.0.0
 */
@RestController
@RequestMapping("cache")
public class CacheController {

    @Autowired private RedisTemplate redisTemplate;

    @PostMapping
    public void setValue(String key,String value) throws IOException {
        this.setValue(key,value,0);
    }

    @GetMapping
    public String getValue(String key) throws IOException {
        String value = "";
        Object object = redisTemplate.opsForValue().get(key);
        if (null == object){
            int seconds = new Random().nextInt(30);
            this.setValue(key,value,seconds);
        }else {
            value = (String) object;
        }
        return value;
    }

    public void setValue(String key, String value, int seconds) {
        Objects.requireNonNull(key);
        if (seconds <= 0){
            redisTemplate.opsForValue().set(key,value);
        }else {
            redisTemplate.opsForValue().set(key,value,seconds, TimeUnit.SECONDS);
        }
    }

}
