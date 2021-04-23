package com.kuang.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author hezihao
 * @version 1.0
 * <p>
 * @date 2021/4/23 2:19 下午
 * <p>
 */
public class CharacterEncodingFilter implements Filter {
    /**
     * 初始化：web服务器启动，就以及初始化了，随时等待过滤对象出现
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter初始化");
    }

    /**
     * 过滤中的所有代码，在过滤特定请求的时候都会执行
     * 必须要让过滤器继续执行
     * filterChain.doFilter(request, response);
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //处理中文乱码问题
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        System.out.println("CharacterEncodingFilter执行前...");
        //让我们的请求继续走，如果不写，程序到这里就停止了
        filterChain.doFilter(request, response);
        System.out.println("CharacterEncodingFilter执行后...");
    }

    /**
     * 销毁：web服务器关闭的时候，过滤器会销毁
     */
    @Override
    public void destroy() {
        System.out.println("CharacterEncodingFilter销毁");
    }
}