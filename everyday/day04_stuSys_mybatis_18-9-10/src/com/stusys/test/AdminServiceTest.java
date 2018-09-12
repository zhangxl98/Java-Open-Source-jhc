package com.stusys.test;

import com.stusys.pojo.AdminInfo;
import com.stusys.service.AdminService;
import com.stusys.service.impl.AdminServiceImpl;
import org.junit.Test;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-4 下午2:51
 */
public class AdminServiceTest {
    @Test
    public void login() {
        AdminService service = new AdminServiceImpl();
        AdminInfo admin = new AdminInfo();
        admin.setUsername("zs");
        admin.setPassword("123456");
        boolean result = service.login(admin);
        if (result) {
            System.out.println("login success!");
        } else {
            System.out.println("login unsuccess!");
        }
    }

    @Test
    public void register() {
        AdminService service = new AdminServiceImpl();
        AdminInfo admin = new AdminInfo();
        admin.setUsername("ww");
        admin.setPassword("123456");
        admin.setRealname("王五");
        int result = service.register(admin);
        if (result > 0) {
            System.out.println("register success!");
        } else if (result == -1) {
            System.out.println("username already exists!");
        } else {
            System.out.println("register unsuccess!");
        }
    }
}
