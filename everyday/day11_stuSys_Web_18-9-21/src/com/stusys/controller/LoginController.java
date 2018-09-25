package com.stusys.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stusys.pojo.AdminInfo;
import com.stusys.service.AdminService;

@Controller
public class LoginController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/dologin.do")

    public String dologin(PrintWriter out, HttpSession session, AdminInfo admin) {
        boolean result = adminService.login(admin);
        if (result) {

            admin = adminService.getAdminByUsername(admin.getUsername());
            session.setAttribute("loginuser", admin);
            return "redirect:/admin/index.do";
        } else {
            out.print("<script>alert('登录失败');history.go(-1);</script>");
            return null;
        }
    }

    @RequestMapping("/login.do")
    public String login() {
        return "login";
    }
}

