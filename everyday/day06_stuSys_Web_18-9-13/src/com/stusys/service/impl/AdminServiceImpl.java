package com.stusys.service.impl;

import com.stusys.dao.impl.AdmininfoDaoImpl;
import com.stusys.dao.AdmininfoDao;
import com.stusys.dao.DbUtils;
import com.stusys.mapper.AdminMapper;
import com.stusys.mybatis.MybatisUtils;
import com.stusys.pojo.AdminInfo;
import com.stusys.service.AdminService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-4 下午2:39
 */
public class AdminServiceImpl implements AdminService {

    private AdminMapper mapper = null;

    @Override
    public boolean login(AdminInfo admin) {
        boolean result = false;
        SqlSessionFactory factory = MybatisUtils.createFactory();
        SqlSession sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(AdminMapper.class);
        AdminInfo realadmin = mapper.selectByName(admin.getUsername());
        if (realadmin != null) {
            if (realadmin.getPassword().equals(admin.getPassword())) {
                result = true;
            }
        }
        sqlSession.close();
        return result;
    }

    @Override
    public int register(AdminInfo admin) {
        int result = 0;
        SqlSessionFactory factory = MybatisUtils.createFactory();
        SqlSession sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(AdminMapper.class);
        AdminInfo realadmin = mapper.selectByName(admin.getUsername());
        if (realadmin != null) {
            result=-1;
        }else {
            result=mapper.insertAdmin(admin);
            sqlSession.commit();
        }
        sqlSession.close();
        return result;
    }
}
