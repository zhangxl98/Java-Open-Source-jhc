package com.stusys.pojo;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-4 下午1:42
 */
public class AdminInfo {
    private int adminid;
    private String username;
    private String password;
    private String realname;

    public AdminInfo() {
    }

    public AdminInfo(int adminid, String username, String password, String realname) {
        this.adminid = adminid;
        this.username = username;
        this.password = password;
        this.realname = realname;
    }

    public int getAdminid() {
        return adminid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRealname() {
        return realname;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Override
    public String toString() {
        return "AdminInfo{" +
                "adminid=" + adminid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                '}';
    }
}
