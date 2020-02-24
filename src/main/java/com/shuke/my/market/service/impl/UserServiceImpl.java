package com.shuke.my.market.service.impl;

import com.shuke.my.market.dao.UserDao;
import com.shuke.my.market.dao.impl.UserDaoImpl;
import com.shuke.my.market.entity.User;
import com.shuke.my.market.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {
//    UserDao userDao = new UserDaoImpl();

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");

    public User login(String email, String loginPwd) {
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        return userDao.login(email,loginPwd);
    }
}
