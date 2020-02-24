package com.shuke.my.market.dao;

import com.shuke.my.market.entity.User;

public interface UserDao {
    public User login(String email, String loginpwd);
}
