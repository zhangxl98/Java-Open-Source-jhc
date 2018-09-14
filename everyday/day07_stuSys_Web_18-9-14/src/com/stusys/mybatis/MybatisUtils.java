package com.stusys.mybatis;

import com.stusys.pojo.AdminInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-13 下午3:24
 */
public class MybatisUtils {
    private static SqlSessionFactory factory = null;

    public static SqlSessionFactory createFactory() {
        String resource = "com/stusys/config/Configuration.xml";
        Reader reader;
        try {
            if (factory == null) {
                reader = Resources.getResourceAsReader(resource);
                factory = new SqlSessionFactoryBuilder().build(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return factory;
    }
}
