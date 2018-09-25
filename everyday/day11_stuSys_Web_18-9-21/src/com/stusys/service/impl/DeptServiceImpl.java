package com.stusys.service.impl;

import com.stusys.mapper.DeptMapper;
import com.stusys.mapper.EmpMapper;
import com.stusys.mybatis.MybatisUtils;
import com.stusys.pojo.Dept;
import com.stusys.service.DeptService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-14 上午9:48
 */
@Service
public class DeptServiceImpl implements DeptService {
    private DeptMapper mapper = null;
    private EmpMapper empMapper = null;

    @Override
    public int addDept(Dept dept) {
        int result = 0;
        SqlSessionFactory factory = MybatisUtils.createFactory();
        SqlSession sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(DeptMapper.class);
        try {
            Dept realdept = mapper.selectByName(dept.getDeptname());
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
        List<Dept> depts = mapper.selectAll();
        sqlSession.close();
        return depts;
    }

    @Override
    public int delDept(int id) {
        int result = 0;
        SqlSessionFactory factory = MybatisUtils.createFactory();
        SqlSession sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(DeptMapper.class);
        empMapper = sqlSession.getMapper(EmpMapper.class);
        try {
            int count = empMapper.selectCountByDept(id);
            if (count == 0) {
                result = mapper.deleteDept(id);
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
    public Dept selectById(int deptid) {
        SqlSessionFactory factory = MybatisUtils.createFactory();
        SqlSession sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.selectById(deptid);
        sqlSession.close();
        return dept;
    }

    @Override
    public int editDept(Dept dept) {
        int result = 0;
        SqlSessionFactory factory = MybatisUtils.createFactory();
        SqlSession sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(DeptMapper.class);
        try {
            Dept realdept = mapper.selectByName(dept.getDeptname());
            if (realdept == null) {
                result = mapper.updateDept(dept);
            } else {
                if (dept.getDeptid() == realdept.getDeptid()) {
                    result = mapper.updateDept(dept);
                } else {
                    result = -1;
                }

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
}
