<%@ page import="com.mongodb.Mongo" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>管理界面</title>
  </head>
  <body>
<c:forEach var="user" items="${userlist}"></c:forEach>

<table border="1px">
  <tr>
    <th>用户id</th>
    <th>UUID</th>
    <th>密码</th>
    <th>通关记录</th>
    <th>操作</th>
  </tr>

  <c:forEach var="user" items="${userlist}">
    <tr>

      <td>${user.userid}</td>
      <td> ${user.UUID}</td>
      <td> ${user.password}</td>
      <td> ${user.record}</td>
      <td> <a href="${pageContext.request.contextPath}/delete.do?userid=${user.userid}">删除</a>
      <a href="${pageContext.request.contextPath}/resetpsw.do?userid=${user.userid}">重置密码</a>
      </td>
    </tr>
  </c:forEach>
</table>



  </body>
</html>
