package com.easy.cloud.user.provider.service;

import com.easy.cloud.user.provider.service.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ：Strong
 * @date ：Created in 2019/12/10 15:51
 * @version: 1.0.0
 */
@FeignClient(value = "user-provider",fallback = UserServiceFallback.class)
public interface UserService {

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable(value = "id") Integer id);
}
