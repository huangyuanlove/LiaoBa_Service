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
<form method="get" action="${pageContext.request.contextPath}/updata.do">
  <input type="text" value="更新" name="version">
  <input type="text" value="amw" name="password">
  <input type="submit" value="提交">
</form>
  </body>
</html>
