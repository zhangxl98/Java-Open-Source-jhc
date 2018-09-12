package com.stusys.pojo;

import java.util.Date;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-7 上午10:08
 */
public class Emp {
    private int empid;
    private String empname;
    private Dept dept;
    private String email;
    private String tel;
    private Date joindate;

    public Emp() {
    }

    public Emp(String empname, Dept dept, String email, String tel, Date joindate) {
        this.empname = empname;
        this.dept = dept;
        this.email = email;
        this.tel = tel;
        this.joindate = joindate;
    }

    public Emp(String empname, String email, String tel, Date joindate) {
        this.empname = empname;
        this.email = email;
        this.tel = tel;
        this.joindate = joindate;
    }

    public Emp(int empid, String empname, Dept dept, String email, String tel, Date joindate) {
        this.empid = empid;
        this.empname = empname;
        this.dept = dept;
        this.email = email;
        this.tel = tel;
        this.joindate = joindate;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empid=" + empid +
                ", empname='" + empname + '\'' +
                ", dept=" + dept +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", joindate=" + joindate +
                '}';
    }
}
