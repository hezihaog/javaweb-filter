package com.kuang.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author hezihao
 * @version 1.0
 * <p>
 * @date 2021/4/23 2:47 下午
 * <p>
 * 统计在线人数，统计session
 */
public class OnlineListener implements HttpSessionListener {
    /**
     * 创建session监听
     */
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        ServletContext context = event.getSession().getServletContext();
        System.out.println(event.getSession().getId());
        Integer onlineCount = (Integer) context.getAttribute("OnlineCount");
        if (onlineCount == null) {
            onlineCount = new Integer(1);
        } else {
            int count = onlineCount.intValue();
            onlineCount = count + 1;
        }
        context.setAttribute("OnlineCount", onlineCount);
    }

    /**
     * 销毁session监听
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        ServletContext context = event.getSession().getServletContext();
        Integer onlineCount = (Integer) context.getAttribute("OnlineCount");
        if (onlineCount == null) {
            onlineCount = new Integer(0);
        } else {
            int count = onlineCount.intValue();
            onlineCount = count - 1;
        }
        context.setAttribute("OnlineCount", onlineCount);
    }

    /**
     * Session销毁
     * 1、手动销毁，getSession().invalidate();
     * 2、自动销毁
     */
}