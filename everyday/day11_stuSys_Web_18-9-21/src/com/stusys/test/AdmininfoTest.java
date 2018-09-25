package com.stusys.test;

import com.stusys.pojo.AdminInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-7 上午9:01
 */
public class AdmininfoTest {
    @Test
    public void selectAll() {
        String resource = "com/stusys/config/Configuration.xml";
        Reader reader;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(reader);
            sqlSession = sqlSessionFactory.openSession();
            List<AdminInfo> admins = sqlSession.selectList("AdminMapper.selectAll");
            for (AdminInfo adminInfo : admins) {
                System.out.println(adminInfo);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void selectByName() {
        String resource = "com/stusys/config/Configuration.xml";
        Reader reader;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(reader);
            sqlSession = sqlSessionFactory.openSession();
            AdminInfo admin = sqlSession.selectOne("AdminMapper.selectByName", "zhangsan");
            System.out.println(admin);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void insertAdmin() {
        String resource = "com/stusys/config/Configuration.xml";
        Reader reader;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(reader);
            sqlSession = sqlSessionFactory.openSession();
            AdminInfo admin = new AdminInfo("ww", "123456", "姚明");
            int result = sqlSession.insert("AdminMapper.insertAdmin", admin);
            sqlSession.commit();
            System.out.println(result);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void deleteAdmin() {
        String resource = "com/stusys/config/Configuration.xml";
        Reader reader;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(reader);
            sqlSession = sqlSessionFactory.openSession();

            int result = sqlSession.delete("AdminMapper.deleteAdmin", 7);
            sqlSession.commit();
            System.out.println(result);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void updateAdmin() {
        String resource = "com/stusys/config/Configuration.xml";
        Reader reader;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(reader);
            sqlSession = sqlSessionFactory.openSession();
            AdminInfo admin = new AdminInfo();
            admin.setAdminid(7);
            admin.setRealname("张明");
            admin.setPassword("789456");
            int result = sqlSession.update("AdminMapper.updateAdmin", admin);
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
