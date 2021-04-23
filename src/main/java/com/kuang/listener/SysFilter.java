package com.kuang.listener;

import com.kuang.util.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hezihao
 * @version 1.0
 * <p>
 * @date 2021/4/23 3:44 下午
 * <p>
 */
public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //如果没有登录，则重定向熬错误页面
        Object userSession = request.getSession().getAttribute(Constant.USER_SESSION);
        if (userSession == null) {
            response.sendRedirect("/error.jsp");
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
    }
}