<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<frameset rows="25%,*">
    <frame src="${pageContext.request.contextPath}/admin/top.do" framrborder="0"/>
    <frameset cols="20%,*" framborder="no">
        <frame src="${pageContext.request.contextPath}/admin/left.do" framrborder="0"/>
        <frame name="main" src="${pageContext.request.contextPath}/admin/main.do" framrborder="0"/>
    </frameset>
</frameset>
</html>