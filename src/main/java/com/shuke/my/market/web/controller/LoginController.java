package com.shuke.my.market.web.controller;

import com.shuke.my.market.dao.impl.UserDaoImpl;
import com.shuke.my.market.entity.User;
import com.shuke.my.market.service.UserService;
import com.shuke.my.market.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String loginPwd = req.getParameter("loginPwd");
        String remMe = req.getParameter("remMe");
        String autoSign = req.getParameter("autoSign");

        logger.info("自动登录信息为：{}",autoSign);
        logger.info("记住我信息为为：{}",remMe);

        User user = userService.login(email, loginPwd);

        //创建Cookie对象
        Cookie nameCookie = new Cookie("email", email);
        Cookie pwdCookie = new Cookie("loginPwd", loginPwd);
        //如果可以记住我
        if (userService.remME(remMe, email, loginPwd)) {
            //设置保存时长，有效期是10天
            nameCookie.setMaxAge(60 * 60 * 24 * 10);
            pwdCookie.setMaxAge(60 * 60 * 24 * 10);
            resp.addCookie(nameCookie);
            resp.addCookie(pwdCookie);
            logger.info("添加Cookie");
        }else {
            nameCookie.setMaxAge(0);
            pwdCookie.setMaxAge(0);
        }

        //登录失败的处理
        if (user == null) {
            req.setAttribute("message","用户名或密码错误");
            logger.info("发送错误消息");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }

        //登录成功的处理
        else {
            logger.info("页面成功跳转");
            req.setAttribute("message",null);
            req.getRequestDispatcher("/success.jsp").forward(req,resp);
        }
    }
}
