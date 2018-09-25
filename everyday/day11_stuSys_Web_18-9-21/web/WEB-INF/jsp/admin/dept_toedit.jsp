<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<h3>部门修改</h3>
<form name="frmdept" action="${pageContext.request.contextPath}/admin/dept/doedit.do" method="post">
    <input name="deptid" value="${requestScope.dept.deptid}" type="hidden"/>
    部门名称:<input name="deptname" type="text" value="${requestScope.dept.deptname}"/><br/>
    部门简介:<textarea name="deptinfo" rows="8" cols="40">${requestScope.dept.deptinfo}</textarea><br/>
    <input name="btnedit" value="修改" type="submit"/>
    <input name="btncancle" value="重置" type="reset"/>
</form>
</body>
</html>