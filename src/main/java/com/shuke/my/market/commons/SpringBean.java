package com.shuke.my.market.commons;

import com.shuke.my.market.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class SpringBean {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
    UserDao userDao = (UserDao) applicationContext.getBean("userDao");
}
