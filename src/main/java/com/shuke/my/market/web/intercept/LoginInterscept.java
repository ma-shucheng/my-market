package com.shuke.my.market.web.intercept;

import com.shuke.my.market.commons.constant.ConstantUtils;
import com.shuke.my.market.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * <p>
 * 登录拦截器
 * </p>
 *
 * @author shuke
 * @version v1.0.0
 * @since 2020-02-26 17:35:49
 * @see com.shuke.my.market.web.intercept
 *
 */
public class LoginInterscept implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);

        //未登录
        if (user == null) {
            httpServletResponse.sendRedirect("/login");
        }
        //放行
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
