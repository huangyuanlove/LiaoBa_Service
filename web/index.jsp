<%@ page import="com.mongodb.Mongo" %>
<%--
  Created by IntelliJ IDEA.
  User: huangyuan
  Date: 16-1-24
  Time: 上午12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>mongoTest</title>
  </head>
  <body>
<form method="get" action="${pageContext.request.contextPath}/login.do">
  <input type="text" value="huangyuan" name="userid">
  <input type="text" value="amw" name="password">
  <input type="submit" value="测试">
</form>
  </body>
</html>
