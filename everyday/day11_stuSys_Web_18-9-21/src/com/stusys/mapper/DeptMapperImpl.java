package com.stusys.mapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.stusys.pojo.Dept;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-20 上午9:33
 */
public class DeptMapperImpl implements DeptMapper {

    @Override
    public List<Dept> selectAll() {
        String resource = "com/stusys/config/Configuration.xml";
        Reader reader;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(reader);
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.selectList("com.stusys.mapper.DeptMapper.selectAll");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return null;
    }

    @Override
    public Dept selectByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Dept selectById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insertDept(Dept dept) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateDept(Dept dept) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteDept(int id) {
        // TODO Auto-generated method stub
        return 0;
    }

}
