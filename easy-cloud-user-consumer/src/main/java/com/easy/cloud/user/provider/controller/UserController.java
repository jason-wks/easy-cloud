package com.easy.cloud.user.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：Strong
 * @date ：Created in 2019/12/10 15:26
 * @version: 1.0.0
 */
@RestController
public class UserController {

   private final RestTemplate restTemplate;

   @Autowired
    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/rest/{id}")
    public String getUserById(@PathVariable(value = "id",required = true) Integer id){
        return restTemplate.getForObject("http://user-provider/user/" + id,String.class);
    }
}
