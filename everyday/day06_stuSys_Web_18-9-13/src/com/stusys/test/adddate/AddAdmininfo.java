package com.stusys.test.adddate;

import com.stusys.pojo.AdminInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-10 上午9:55
 */
public class AddAdmininfo {
    public static void main(String[] args) {
        for (int i = 0; i < 999; i++) {
            insertAdmin("zl" + i, "123456", "zhaoliu" + i);
        }
    }

    public static void insertAdmin(String username, String password, String realname) {
        String resource = "com/stusys/config/Configuration.xml";
        Reader reader;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(reader);
            sqlSession = sqlSessionFactory.openSession();
            AdminInfo admin = new AdminInfo(username, password, realname);
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
}
