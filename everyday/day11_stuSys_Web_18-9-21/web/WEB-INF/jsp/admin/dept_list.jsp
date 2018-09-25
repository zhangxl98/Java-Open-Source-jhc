<%--
  Created by IntelliJ IDEA.
  User: vm
  Date: 18-9-14
  Time: 上午10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>dept list</title>
</head>
<body>
<table>
    <tr>
        <td>
            部门名称
        </td>
        <td>
            操作
        </td>
    </tr>
    <c:forEach items="${requestScope.depts}" var="dept">
        <tr>
            <td>
                    ${dept.deptname}
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/dept/toedit.do?id=${dept.deptid}">修改</a>
                <a href="${pageContext.request.contextPath}/admin/dept/del.do?id=${dept.deptid}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
