package com.kuang.servlet;

import com.kuang.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hezihao
 * @version 1.0
 * <p>
 * @date 2021/4/23 3:28 下午
 * <p>
 */
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object userSession = req.getSession().getAttribute(Constant.USER_SESSION);
        if (userSession != null) {
            //注销登录
            req.getSession().removeAttribute(Constant.USER_SESSION);
            //重定向回登录页面
            resp.sendRedirect("/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}