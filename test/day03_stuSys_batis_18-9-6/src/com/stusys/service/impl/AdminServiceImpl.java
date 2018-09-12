package com.stusys.service.impl;

import com.stusys.dao.impl.AdmininfoDaoImpl;
import com.stusys.dao.AdmininfoDao;
import com.stusys.dao.DbUtils;
import com.stusys.pojo.AdminInfo;
import com.stusys.service.AdminService;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-4 下午2:39
 */
public class AdminServiceImpl implements AdminService {

    private AdmininfoDao dao = new AdmininfoDaoImpl();

    @Override
    public boolean login(AdminInfo admin) {
        boolean result = false;
        Connection conn = DbUtils.createConn();
        try {
            AdminInfo realadmin = dao.selectByUsername(conn, admin.getUsername());
            if (realadmin != null) {
                if (realadmin.getPassword().equals(admin.getPassword())) {
                    result = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public int register(AdminInfo admin) {
        int result = 0;
        Connection conn = DbUtils.createConn();
        try {
            AdminInfo realadmin = dao.selectByUsername(conn, admin.getUsername());
            if (realadmin == null) {
                result = dao.insertAdmin(conn, admin);
            }else {
                result = -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
