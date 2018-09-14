<%--
  Created by IntelliJ IDEA.
  User: vm
  Date: 18-9-14
  Time: 上午9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add dept</title>
</head>
<body>
<h3>add dept</h3>
<form name="frmdept" action="${pageContext.request.contextPath}admin/dodept.do?op=doadd" method="post">
    deptname:<input type="text" name="username"><br>
    deptinfo:<<textarea name="deptinfo" cols="30" rows="10"></textarea><br>
    <input type="submit" value="add">
    <input type="submit" value="reset">
</form>
</body>
</html>
