<%@ page import="com.kuang.util.Constant" %><%--
  Created by IntelliJ IDEA.
  User: wally
  Date: 2021/4/23
  Time: 3:21 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
<%
    //如果没有登录，则不允许注销，缺点是，每次都写一次，应该用过滤器
//    Object userSession = request.getSession().getAttribute(Constant.USER_SESSION);
//    if (userSession == null) {
//        response.sendRedirect("/login.jsp");
//    }
%>
<h1>主页</h1>
<p>
    <a href="/servlet/logout">注销</a>
</p>
</body>
</html>
