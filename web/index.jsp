<%--
  Created by IntelliJ IDEA.
  User: wally
  Date: 2021/4/23
  Time: 2:05 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线人数</title>
</head>
<body>
<h1>当前有 <span style="color: blue"><%=this.getServletConfig().getServletContext().getAttribute("OnlineCount")%></span>
    人在线</h1>
</body>
</html>
