package com.stusys.servlet;

import com.stusys.pojo.Dept;
import com.stusys.service.DeptService;
import com.stusys.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-14 上午9:57
 */
@WebServlet(urlPatterns = {"/admin/dodept.do"})
public class DeptServlet extends HttpServlet {

    DeptService deptService = new DeptServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset=utf-8");
        String action = req.getParameter("op");
        if ("doadd".equals(action)) {
            doadd(req, resp);
        } else if ("list".equals(action)) {
            dolist(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doadd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptname = req.getParameter("deptname");
        String deptinfo = req.getParameter("deptinfo");
        Dept dept = new Dept(deptname, deptinfo);
        PrintWriter out = resp.getWriter();
        int result = deptService.addDept(dept);
        if (result > 0) {
            resp.sendRedirect(req.getContextPath() + "/admin/dodept.do?op=list");
        } else if (result == 0) {
            out.print("<script>alert('添加失败！');history.go(-1);</script>");
        } else {
            out.print("<script>alert('部门名重复，添加失败！');history.go(-1);</script>");
        }
    }

    protected void dolist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dept> depts = deptService.getAllDepts();
        req.setAttribute("depts", depts);
        req.getRequestDispatcher("/admin/dept_list.jsp").forward(req, resp);
    }

    protected void doedit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptname = req.getParameter("deptname");
        String deptinfo = req.getParameter("deptinfo");
        int deptid = Integer.valueOf(req.getParameter("deptid"));
        Dept dept = new Dept(deptname, deptinfo);
        dept.setDeptid(deptid);
        PrintWriter out = resp.getWriter();
        int result = deptService.editDept(dept);
        if (result > 0) {
            resp.sendRedirect(req.getContextPath()
                    + "/admin/dodept.do?op=list");
        } else if (result == 0) {
            out.print("<script>alert('修改失败！');history.go(-1);</script>");
        } else {
            out.print("<script>alert('部门名重复，修改失败！');history.go(-1);</script>");

        }
    }

    protected void dodel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int deptid = Integer.valueOf(req.getParameter("id"));

        PrintWriter out = resp.getWriter();
        int result = deptService.delDept(deptid);
        if (result > 0) {
            resp.sendRedirect(req.getContextPath()
                    + "/admin/dodept.do?op=list");
        } else if (result == 0) {
            out.print("<script>alert('删除失败！');history.go(-1);</script>");
        } else {
            out.print("<script>alert('该部门下还有员工，删除失败！');history.go(-1);</script>");

        }

    }

    protected void toedit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        Dept dept = deptService.selectById(id);
        req.setAttribute("dept", dept);
        req.getRequestDispatcher("/admin/dept_toedit.jsp").forward(req, resp);
    }
}