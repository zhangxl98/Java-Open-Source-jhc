package com.stusys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-4 下午1:25
 */
public class DbUtils {
    public static Connection createConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/studb?seUnicode=ture&characterEncoding=UTF8";
        try {
            conn = DriverManager.getConnection(url, "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return conn;
    }
}
