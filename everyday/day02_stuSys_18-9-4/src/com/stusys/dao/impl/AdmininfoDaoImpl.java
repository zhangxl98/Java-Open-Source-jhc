package com.stusys.dao.impl;

import com.stusys.dao.AdmininfoDao;
import com.stusys.dao.BaseDao;
import com.stusys.pojo.AdminInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-4 下午1:56
 */
public class AdmininfoDaoImpl extends BaseDao implements AdmininfoDao {
    @Override
    public int insertAdmin(Connection conn, AdminInfo admin) throws SQLException {
        String sql = "insert into admininfo(username,password,realname)values(?,?,?)";
        int result = super.executeUpdate(conn, sql, admin.getUsername(), admin.getPassword(), admin.getRealname());
        return result;
    }

    @Override
    public List<AdminInfo> selectAll(Connection conn) throws SQLException {
        List<AdminInfo> admins = new ArrayList<AdminInfo>();
        String sql = "select * from admininfo order by adminid desc";
        ResultSet rs = super.executeQuery(conn, sql);
        while (rs.next()) {
            AdminInfo admin = new AdminInfo();
            admin.setAdminid(rs.getInt("adminid"));
            admin.setPassword(rs.getString("password"));
            admin.setUsername(rs.getString("username"));
            admin.setRealname(rs.getString("realname"));
            admins.add(admin);
        }
        return admins;
    }

    @Override
    public AdminInfo selectByUsername(Connection conn, String username) throws SQLException {
        AdminInfo admin = null;
        String sql = "select * from admininfo where username=?";
        ResultSet rs = super.executeQuery(conn, sql, username);
        while (rs.next()) {
            admin = new AdminInfo();
            admin.setAdminid(rs.getInt("adminid"));
            admin.setPassword(rs.getString("password"));
            admin.setUsername(rs.getString("username"));
            admin.setRealname(rs.getString("realname"));
        }
        return admin;
    }

    @Override
    public int delById(Connection conn, int adminid) throws SQLException {
        String sql = "delete from admininfo where adminid=?";
        int result = super.executeUpdate(conn, sql, adminid);
        return result;
    }

    @Override
    public int updateAdmin(Connection conn, AdminInfo admin) throws SQLException {
        String sql = "update admininfo set password=?,realname=? where adminid=?)";
        int result = super.executeUpdate(conn, sql, admin.getPassword(), admin.getRealname(), admin.getAdminid());
        return result;
    }
}
