package com.stusys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-4 下午12:58
 */
public class BaseDao {
    public int executeUpdate(Connection conn, String sql, Object... values) throws SQLException {
        /**
         *
         * @Description 通用的增删改
         * @author zhangxiaoliang98
         * @date 18-9-4 下午1:09
         * @param conn
         * @param sql 要执行的 insert update delete 语句
         * @param values 传递 ? 对应的值
         * @return int 返回影响的行数
         *
         */
        int result = 0;

            PreparedStatement pstms = conn.prepareStatement(sql);
            if (values != null) {
                for (int i = 0; i < values.length; i++) {
                    pstms.setObject(i+1, values[i]);
                }
            }
            result = pstms.executeUpdate();
        return result;
    }

    public ResultSet executeQuery(Connection conn, String sql, Object... values) throws SQLException {
        /**
         *
         * @Description 通用的查询方法
         * @author zhangxiaoliang98
         * @date 18-9-4 下午1:09
         * @param conn
         * @param sql 要执行的 select 语句
         * @param values 传递 ? 对应的值
         * @return java.sql.ResultSet 返回结果集
         *
         */
        ResultSet rs = null;

        PreparedStatement pstms = conn.prepareStatement(sql);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                pstms.setObject(i+1, values[i]);
            }
        }
        rs = pstms.executeQuery();
        return rs;
    }
}