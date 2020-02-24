package com.shuke.my.market.service;

import com.shuke.my.market.entity.User;

public interface UserService {
    public User login(String email, String loginPwd);
}
