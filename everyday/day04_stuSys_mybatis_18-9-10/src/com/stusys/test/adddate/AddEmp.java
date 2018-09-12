package com.stusys.test.adddate;

import com.stusys.pojo.Dept;
import com.stusys.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-10 上午10:05
 */
public class AddEmp {
    public static void main(String[] args) {
        for (int i = 0; i < 999; i++) {
            insertEmp("zhangsan" + i, "zs" + i + "@163.com", "13322332233", new Date());
        }
    }

    public static void insertEmp(String empname, String email, String tel, Date date) {
        String resource = "com/stusys/config/Configuration.xml";
        Reader reader;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            Emp emp = new Emp(empname, email, tel, date);
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
