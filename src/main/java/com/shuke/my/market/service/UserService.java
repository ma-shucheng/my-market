package com.shuke.my.market.service;

import com.shuke.my.market.entity.User;

public interface UserService {
    public User login(String email, String loginPwd);
    public Boolean remME(String remMe,String email, String loginPwd);
    public Boolean autoSign(String autoSign,String email, String loginPwd);
}
