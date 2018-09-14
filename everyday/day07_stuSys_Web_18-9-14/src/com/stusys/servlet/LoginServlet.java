package com.stusys.servlet;

import com.stusys.pojo.AdminInfo;
import com.stusys.service.AdminService;
import com.stusys.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-14 上午9:13
 */
@WebServlet(urlPatterns = {"dologin.do"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        AdminInfo admin = new AdminInfo(username, password);
        AdminService adminService = new AdminServiceImpl();
        boolean result = adminService.login(admin);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        if (result) {
            out.print("login success!");
        } else {
            out.print("login unsuccess!");
        }
    }
}
