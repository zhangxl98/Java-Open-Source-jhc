package com.stusys.service;

import com.stusys.pojo.AdminInfo;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-4 下午2:37
 */
public interface AdminService {
    public boolean login(AdminInfo admin);

    public int register(AdminInfo admin);

    public AdminInfo getAdminByUsername(String username);
}
