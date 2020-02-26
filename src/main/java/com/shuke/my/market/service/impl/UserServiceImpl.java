package com.shuke.my.market.service.impl;

import com.shuke.my.market.commons.context.SpringContext;
import com.shuke.my.market.dao.UserDao;
import com.shuke.my.market.entity.User;
import com.shuke.my.market.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
//    UserDao userDao = new UserDaoImpl();

    UserDao userDao = SpringContext.getBean("userDao");

    public User login(String email, String loginPwd) {
        return userDao.login(email,loginPwd);
    }

    public Boolean remME(String remMe, String email, String loginPwd) {
        return userDao.remME(remMe,email,loginPwd);
    }

    public Boolean autoSign(String autoSign, String email, String loginPwd) {
        return userDao.autoSign(autoSign,email,loginPwd);
    }

}
