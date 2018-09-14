package com.stusys.pojo;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-7 上午9:10
 */
public class Dept {
    private int deptid;
    private String deptname;
    private String deptinfo;

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
}
