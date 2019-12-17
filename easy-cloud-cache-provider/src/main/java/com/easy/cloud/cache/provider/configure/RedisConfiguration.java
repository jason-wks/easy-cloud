package com.easy.cloud.cache.provider.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

/**
 * @author ：Strong
 * @date ：Created in 2019/12/12 10:10
 * @version: 1.0.0
 */
@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        GenericJackson2JsonRedisSerializer jrs = new GenericJackson2JsonRedisSerializer();
        // 设置value的序列化规则和 key的序列化规则
        redisTemplate.setDefaultSerializer(jrs);
        return redisTemplate;
    }

}
