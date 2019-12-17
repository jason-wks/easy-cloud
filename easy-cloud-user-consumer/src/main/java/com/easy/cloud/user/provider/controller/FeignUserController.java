package com.easy.cloud.user.provider.controller;

import com.easy.cloud.user.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RefreshScope动态刷新
 * @author ：Strong
 * @date ：Created in 2019/12/10 15:51
 * @version: 1.0.0
 */
@RefreshScope
@RestController
public class FeignUserController {

    @Autowired private UserService userService;

    @Value("${user.name}")
    private String userName;

    @GetMapping("/feign/{id}")
    public String getUserById(@PathVariable(value = "id",required = true) Integer id){
        System.out.println(userName);
        return userService.getUserById(id);
    }
}
