package cn.jhc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class JdbcTest {
    @Test
    public void testSelect() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/studb";
        String uid = "root";
        String pwd = "123456";
        PreparedStatement pstms = null;
        ResultSet rs = null;
        // 加载  mysql 驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            // Java 与 Database 之间的桥梁
            conn = DriverManager.getConnection(url, uid, pwd);
            // 描述清楚要做的事情
            String sql = "select * from admininfo order by adminid desc";
            // 根据 conn 创建执行 sql 语句的工人
            pstms = conn.prepareStatement(sql);
            // 开始执行 sql 语句,得到相应的执行结果
            rs = pstms.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("adminid");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String realname = rs.getString("realname");
                System.out.println(id + ":" + username + ":" + password + ":" + realname);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void testInsert(){
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/studb?seUnicode=ture&characterEncoding=UTF8";
        String uid = "root";
        String pwd = "123456";
        PreparedStatement pstms = null;
        ResultSet rs = null;
        // 加载  mysql 驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            // Java 与 Database 之间的桥梁
            conn = DriverManager.getConnection(url, uid, pwd);
            // 描述清楚要做的事情
            String sql = "insert into admininfo(username,password,realname)values(?,?,?)";
            // 根据 conn 创建执行 sql 语句的工人
            pstms = conn.prepareStatement(sql);
            pstms.setString(1, "zl");
            pstms.setString(2, "123456");
            pstms.setString(3, "赵六");
            // 开始执行 sql 语句,得到相应的执行结果
            int row = pstms.executeUpdate();
            if (row > 0) {
                System.out.println("insert success!");
            } else {
                System.out.println("insert unsuccess!");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void testDelete(){
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/studb";
        String uid = "root";
        String pwd = "123456";
        PreparedStatement pstms = null;
        ResultSet rs = null;
        // 加载  mysql 驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            // Java 与 Database 之间的桥梁
            conn = DriverManager.getConnection(url, uid, pwd);
            // 描述清楚要做的事情
            String sql = "delete from admininfo where adminid=?";
            // 根据 conn 创建执行 sql 语句的工人
            pstms = conn.prepareStatement(sql);
            pstms.setInt(1, 3);
            // 开始执行 sql 语句,得到相应的执行结果
            int row = pstms.executeUpdate();
            if (row > 0) {
                System.out.println("delete success!");
            } else {
                System.out.println("delete unsuccess!");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void testUpdate(){
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/studb?seUnicode=ture&characterEncoding=UTF8";
        String uid = "root";
        String pwd = "123456";
        PreparedStatement pstms = null;
        ResultSet rs = null;
        // 加载  mysql 驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            // Java 与 Database 之间的桥梁
            conn = DriverManager.getConnection(url, uid, pwd);
            // 描述清楚要做的事情
            String sql = "update admininfo set password=?,realname=? where adminid=?";
            // 根据 conn 创建执行 sql 语句的工人
            pstms = conn.prepareStatement(sql);
            pstms.setString(1, "123456");
            pstms.setString(2, "张三");
            pstms.setInt(3, 1);
            // 开始执行 sql 语句,得到相应的执行结果
            int row = pstms.executeUpdate();
            if (row > 0) {
                System.out.println("update success!");
            } else {
                System.out.println("update unsuccess!");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
