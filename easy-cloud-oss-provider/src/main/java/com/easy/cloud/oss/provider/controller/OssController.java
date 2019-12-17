package com.easy.cloud.oss.provider.controller;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.easy.cloud.oss.provider.configure.OssProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;

/**
 * @author ：Strong
 * @date ：Created in 2019/12/11 17:08
 * @version: 1.0.0
 */
@RestController
@RequestMapping("oss")
public class OssController {

    @Autowired private OssProperties ossProperties;
    @Autowired private OSSClient ossClient;

    @PostMapping
    public void uploadFile(){
        File file = new File("E:\\software\\远程连接SSH服务器\\winscp.zip");
        String key = ossProperties.getFileHost() + "/" + LocalDateTime.now().toString() + "/" + file.getName();
        String bucketName = ossProperties.getBucketName().get("public");
        PutObjectResult aPublic = ossClient.putObject(new PutObjectRequest(bucketName, key, file));
        System.out.println(aPublic);
    }

}
