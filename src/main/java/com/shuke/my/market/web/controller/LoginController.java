package com.shuke.my.market.web.controller;

import com.shuke.my.market.commons.context.SpringContext;
import com.shuke.my.market.commons.utils.CookieUtils;
import com.shuke.my.market.dao.impl.UserDaoImpl;
import com.shuke.my.market.entity.User;
import com.shuke.my.market.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    private static final String COM_SHUKE_LOGINFO = "logInfo";
    private UserService userService = SpringContext.getBean("userService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] logInfo = CookieUtils.getCookieValue(req, COM_SHUKE_LOGINFO).split(":");
        //如果缓存不为空则给前端赋值
        if (!StringUtils.isEmpty(logInfo[0])) {
            req.setAttribute("email",logInfo[0]);
            req.setAttribute("loginPwd",logInfo[1]);
            req.setAttribute("remMe",true);
        }
        //如果为空则给前端赋空值
        else {
            req.setAttribute("remMe",false);
        }
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String loginPwd = req.getParameter("loginPwd");
        Boolean remMe = req.getParameter("remMe")==null?false:true;
        String autoSign = req.getParameter("autoSign");

        logger.info("自动登录信息为：{}",autoSign);
        logger.info("记住我信息为为：{}",remMe);

        User user = userService.login(email, loginPwd);

        //登录失败的处理
        if (user == null) {
            req.setAttribute("message","用户名或密码错误");
            logger.info("发送错误消息");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

        //登录成功的处理
        else {
            logger.info("页面成功跳转");
            req.setAttribute("message",null);
            req.getRequestDispatcher("/success.jsp").forward(req,resp);
        }

        //如果点击记住我,将用户名和密码信息存入Cookie
        if (remMe) {
            CookieUtils.setCookie(req,resp,COM_SHUKE_LOGINFO,String.format("%s:%s",email,loginPwd),7*24*60*60);
        }
        //如果没有点击，则删除Cookie缓存
        else {
            CookieUtils.setCookie(req,resp,COM_SHUKE_LOGINFO,null,0);
        }

    }
}
