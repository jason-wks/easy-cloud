package com.easy.cloud.oss.provider.configure;

import com.aliyun.oss.OSSClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：Strong
 * @date ：Created in 2019/12/11 16:50
 * @version: 1.0.0
 */
@Configuration
@EnableConfigurationProperties(OssProperties.class)
@ConditionalOnClass(OssProperties.class)
public class OssConfigure {
    final private OssProperties ossProperties;

    public OssConfigure(OssProperties ossProperties) {
        this.ossProperties = ossProperties;
    }

    @Bean
    public OSSClient ossClient(){
        return new OSSClient(ossProperties.getEndpoint(),ossProperties.getAccessKeyId(),ossProperties.getAccessKeySecret());
    }
}
