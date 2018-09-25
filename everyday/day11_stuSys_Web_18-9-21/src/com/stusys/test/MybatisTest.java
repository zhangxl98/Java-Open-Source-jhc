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
 * @date 18-9-6 下午3:37
 */
public class MybatisTest {
    @Test
    public void selectAll() {
        String resource = "com/stusys/config/Configuration.xml";
        Reader reader = null;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            List<AdminInfo> admins = sqlSession.selectList("AdminMapper.selectAll");
            for (AdminInfo adminInfo : admins) {
                System.out.println(adminInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
