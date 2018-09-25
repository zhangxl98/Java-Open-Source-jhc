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
<h3>部门添加</h3>
<form name="frmdept" action="${pageContext.request.contextPath }/admin/dept/doadd.do" method="post">
    部门名称:<input type="text" name="deptname"><br>
    部门简介:<<textarea name="deptinfo" cols="30" rows="10"></textarea><br>
    <input type="submit" value="添加">
    <input type="submit" value="重置">
</form>
</body>
</html>
