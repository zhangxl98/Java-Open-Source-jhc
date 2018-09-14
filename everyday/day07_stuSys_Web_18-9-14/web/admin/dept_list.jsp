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
            deptname
        </td>
        <td>
            todo
        </td>
    </tr>
    <c:forEach items="${requestScope.depts}" var="dept">
        <tr>
            <td>
                ${dept.deptname}
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/dodept.do?op=toedit&id=${dept.deptid}">update</a>
                <a href="${pageContext.request.contextPath}/admin/dodept.do?op=del&id=${dept.deptid}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
