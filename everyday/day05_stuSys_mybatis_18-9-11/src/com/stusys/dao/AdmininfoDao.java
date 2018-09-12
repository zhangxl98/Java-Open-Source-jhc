package com.stusys.dao;

import com.stusys.pojo.AdminInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-4 下午1:41
 */
public interface AdmininfoDao {
    public int insertAdmin(Connection conn, AdminInfo admin) throws SQLException;
    public List<AdminInfo> selectAll(Connection conn) throws SQLException;
    public AdminInfo selectByUsername(Connection conn, String username) throws SQLException;
    public int delById(Connection conn, int adminid) throws SQLException;
    public int updateAdmin(Connection conn, AdminInfo admin) throws SQLException;

}
