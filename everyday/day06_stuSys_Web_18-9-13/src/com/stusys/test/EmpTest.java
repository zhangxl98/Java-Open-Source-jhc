package com.stusys.test;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

import com.stusys.utils.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.stusys.pojo.Dept;
import com.stusys.pojo.Emp;

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
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            Emp emp = sqlSession.selectOne("EmpMapper.selectById", 10);
            System.out.println(emp);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void selectByPage() {
        String resource = "com/stusys/config/Configuration.xml";
        Reader reader;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            Emp empwhere = new Emp();
            empwhere.setEmpname("zhang");
            Dept dept = new Dept();
            dept.setDeptid(1);
            empwhere.setDept(dept);
            List<Emp> emps = sqlSession.selectList("EmpMapper.selectByWhere", empwhere);
            for (Emp emp : emps) {
                System.out.println(emp);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void selectByWherePage() {
        String resource = "com/stusys/config/Configuration.xml";
        Reader reader;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            Emp empwhere = new Emp();
            empwhere.setEmpname("zhang");
            Dept dept = new Dept();
            dept.setDeptid(1);
            empwhere.setDept(dept);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("emp", empwhere);
            map.put("startindex", 25);
            map.put("pagesize", 2);
            List<Emp> emps = sqlSession.selectList("EmpMapper.selectByWherePage", map);
            for (Emp emp : emps) {
                System.out.println(emp);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void selectAll() {
        String resource = "com/stusys/config/Configuration.xml";
        Reader reader;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            List<Emp> emps = sqlSession.selectList("EmpMapper.selectAll");
            for (Emp emp : emps) {
                System.out.println(emp);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void delMany() {
        String resource = "com/stusys/config/Configuration.xml";
        Reader reader;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
//            List<Integer> empids = new ArrayList<Integer>();
//            int start = 20;
//            int end = 200;
//            for (int i = start; i < end + 1; i++) {
//                empids.add(i);
//            }
            Integer[] empids = {999, 998, 997};
            int result = sqlSession.delete("EmpMapper.delMany", empids);
            System.out.println(result);
            sqlSession.commit();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            Emp emp = new Emp("zhangsan", "zs@163.com", "13322223333", new Date());
            Dept dept = new Dept();
            dept.setDeptid(1);
            emp.setDept(dept);
            int result = sqlSession.insert("EmpMapper.insertEmp", emp);
            sqlSession.commit();
            System.out.println(result);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }
}
