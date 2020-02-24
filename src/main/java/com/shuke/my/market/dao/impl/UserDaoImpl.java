package com.shuke.my.market.dao.impl;

import com.shuke.my.market.dao.UserDao;
import com.shuke.my.market.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoImpl implements UserDao {

    private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    public User login(String email, String loginPwd) {
        User user = null;

        logger.info("接收到用户邮箱：{} 密码：{} ",email,loginPwd);

        if (email.equals("admin@qq.com")) {
            if (loginPwd.equals("admin")) {
                user = new User();
                user.setEmail("admin@qq.com");
                user.setLoginPwd("admin");
                user.setLoginId("shuke");
                logger.info("创建对象用户名、邮箱、密码分别为：{}  {}  {}",user.getLoginId(),user.getEmail(),user.getLoginPwd() );
            }
        }
        return user;
    }
}
