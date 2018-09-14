<%@ page import="com.stusys.pojo.AdminInfo" %>
<%@ page import="com.stusys.service.AdminService" %>
<%@ page import="com.stusys.service.impl.AdminServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: vm
  Date: 18-9-14
  Time: 上午6:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String username=request.getParameter("username");
String password=request.getParameter("password");
    AdminInfo admin=new AdminInfo(username,password);
    AdminService adminService=new AdminServiceImpl();
    boolean result =adminService.login(admin);
    if (result) {
        out.print("login success!");
    } else {
        out.print("login unsuccess!");
    }
%>