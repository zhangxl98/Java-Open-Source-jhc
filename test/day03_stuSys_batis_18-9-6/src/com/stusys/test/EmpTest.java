package com.stusys.test;

import com.stusys.pojo.Dept;
import com.stusys.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-7 上午10:30
 */
public class EmpTest {
    @Test
    public void selectById() {
        String resource = "com/stusys/config/Configuration.xml";
        Reader reader;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(reader);
            sqlSession = sqlSessionFactory.openSession();
            Emp emp = sqlSession.selectOne("EmpMapper.selectById",1);
            System.out.println(emp);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            sqlSession.close();
        }

    }

    @Test
    public void insertEmp() {
        String resource = "com/stusys/config/Configuration.xml";
        Reader reader;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(reader);
            sqlSession = sqlSessionFactory.openSession();
            Emp emp = new Emp("zhangsan", "zs@163.com", "13322223333", new Date());
            Dept dept = new Dept();
            dept.setDeptid(1);
            emp.setDept(dept);
            int result = sqlSession.insert("EmpMapper.insertEmp",emp);
            sqlSession.commit();
            System.out.println(result);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            sqlSession.close();
        }

    }
}
