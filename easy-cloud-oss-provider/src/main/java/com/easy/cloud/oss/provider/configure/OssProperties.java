package com.easy.cloud.oss.provider.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * @author ：Strong
 * @date ：Created in 2019/12/11 16:51
 * @version: 1.0.0
 */
@ConfigurationProperties(prefix = "spring.oss")
public class OssProperties {

    private String endpoint = "oss-cn-hangzhou.aliyuncs.com";  //默认杭州阿里云
    private String accessKeyId = "LTAIKPq5HO0F539F";
    private String accessKeySecret = "PNnkEmxOWYDP4LDanmLXMV8gkWUknH";
    private Map<String,String> bucketName;	//创建bucket时的命名
    private String fileHost;	//文件路径
    private Map<String,String> fileUrl;  //文件上传塔
    private List<String> picTypes;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public Map<String, String> getBucketName() {
        return bucketName;
    }

    public void setBucketName(Map<String, String> bucketName) {
        this.bucketName = bucketName;
    }

    public String getFileHost() {
        return fileHost;
    }

    public void setFileHost(String fileHost) {
        this.fileHost = fileHost;
    }

    public Map<String, String> getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(Map<String, String> fileUrl) {
        this.fileUrl = fileUrl;
    }

    public List<String> getPicTypes() {
        return picTypes;
    }

    public void setPicTypes(List<String> picTypes) {
        this.picTypes = picTypes;
    }
}
