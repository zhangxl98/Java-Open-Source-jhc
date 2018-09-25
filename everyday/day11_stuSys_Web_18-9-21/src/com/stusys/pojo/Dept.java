package com.stusys.pojo;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-7 上午9:10
 */
public class Dept {
    private int deptid = 1;
    private String deptname = "技术部";
    private String deptinfo = "负责技术相关工作";

    public Dept() {
    }

    public Dept(String deptname, String deptinfo) {
        this.deptname = deptname;
        this.deptinfo = deptinfo;
    }

    public Dept(int deptid, String deptname, String deptinfo) {
        this.deptid = deptid;
        this.deptname = deptname;
        this.deptinfo = deptinfo;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDeptinfo() {
        return deptinfo;
    }

    public void setDeptinfo(String deptinfo) {
        this.deptinfo = deptinfo;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptid=" + deptid +
                ", deptname='" + deptname + '\'' +
                ", deptinfo='" + deptinfo + '\'' +
                '}';
    }

    public void show() {
        System.out.println("Dept [deptid=" + deptid + ", deptname=" + deptname
                + ", deptinfo=" + deptinfo + "]");
    }

    public void show(String name) {
        System.out.println("hello" + name);
        System.out.println("Dept [deptid=" + deptid + ", deptname=" + deptname
                + ", deptinfo=" + deptinfo + "]");
    }

}
