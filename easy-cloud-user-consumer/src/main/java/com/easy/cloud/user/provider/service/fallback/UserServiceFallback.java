package com.easy.cloud.user.provider.service.fallback;

import com.easy.cloud.user.provider.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFallback implements UserService {
    @Override
    public String getUserById(Integer id) {
        return "网络断开";
    }
}
