package com.stusys.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stusys.pojo.Dept;
import com.stusys.service.DeptService;

@Controller
@RequestMapping("/admin/dept/")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping("toadd.do")
    public String toadd() {
        return "admin/dept_toadd";
    }

    @RequestMapping("list.do")
    public String list(HttpServletRequest request) {
        List<Dept> depts = deptService.getAllDepts();
        request.setAttribute("depts", depts);
        return "admin/dept_list";
    }

    @RequestMapping("doadd.do")
    public String doadd(PrintWriter out, Dept dept) {
        int result = deptService.addDept(dept);
        if (result > 0) {
            return "redirect:/admin/dept/list.do";
        } else if (result == 0) {
            out.print("<script>alert('添加失败！');history.go(-1);</script>");
            return null;
        } else {
            out.print("<script>alert('部门名重复，添加失败！');history.go(-1);</script>");
            return null;
        }

    }

    @RequestMapping("toedit.do")
    public String toedit(HttpServletRequest request, int id) {
        Dept dept = deptService.selectById(id);
        request.setAttribute("dept", dept);
        return "admin/dept_toedit";
    }

    @RequestMapping("doedit.do")
    public String doedit(PrintWriter out, Dept dept) {
        int result = deptService.editDept(dept);
        if (result > 0) {
            return "redirect:/admin/dept/list.do";
        } else if (result == 0) {
            out.print("<script>alert('修改失败！');history.go(-1);</script>");
            return null;
        } else {
            out.print("<script>alert('部门名重复，修改失败！');history.go(-1);</script>");
            return null;
        }

    }

    @RequestMapping("del.do")
    public String del(PrintWriter out, int id) {
        int result = deptService.delDept(id);
        if (result > 0) {
            return "redirect:/admin/dept/list.do";
        } else if (result == 0) {
            out.print("<script>alert('删除失败！');history.go(-1);</script>");
            return null;
        } else {
            out.print("<script>alert('该部门下还有员工，删除失败！');history.go(-1);</script>");
            return null;
        }
    }
}
