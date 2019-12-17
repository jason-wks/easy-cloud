package com.easy.cloud.user.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Strong
 * @date ：Created in 2019/12/10 15:15
 * @version: 1.0.0
 */
@RestController
public class UserController {

    @GetMapping("/{id}")
    public String getUserById(@PathVariable(value = "id",required = true) Integer id){
        return "this is user id :" + id;
    }
}
