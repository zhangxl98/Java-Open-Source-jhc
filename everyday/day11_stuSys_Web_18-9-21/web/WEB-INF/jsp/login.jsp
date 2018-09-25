<%--
  Created by IntelliJ IDEA.
  User: vm
  Date: 18-9-13
  Time: 下午4:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Longin</title>
</head>
<body>
<h3>用户登录</h3>
<form name="frmlogin" action="${pageContext.request.contextPath }/dologin.do" method="post">
    用户名:<input type="text" name="username"><br>
    密码:<input type="password" name="password"><br>
    <input type="submit" value="登录">
    <input type="submit" value="重置">
</form>
</body>
</html>
