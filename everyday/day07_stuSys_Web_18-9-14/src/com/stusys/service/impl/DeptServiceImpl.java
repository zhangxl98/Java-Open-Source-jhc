package com.stusys.service.impl;

import com.stusys.mapper.DeptMapper;
import com.stusys.mybatis.MybatisUtils;
import com.stusys.pojo.Dept;
import com.stusys.service.DeptService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-14 上午9:48
 */
public class DeptServiceImpl implements DeptService {
    private DeptMapper mapper = null;

    @Override
    public int addDept(Dept dept) {
        int result = 0;
        SqlSessionFactory factory = MybatisUtils.createFactory();
        SqlSession sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(DeptMapper.class);
        Dept realdept = mapper.selectByName(dept.getDeptname());
        try {
            if (realdept == null) {
                result = mapper.insertDept(dept);
            } else {
                result = -1;
            }
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return result;
    }

    @Override
    public List<Dept> getAllDepts() {
        SqlSessionFactory factory = MybatisUtils.createFactory();
        SqlSession sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> depts=mapper.selectAll();
        sqlSession.close();
        return depts;
    }
}
