package com.stusys.mapper;

import com.stusys.pojo.AdminInfo;

import java.util.List;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-13 下午3:15
 */
public interface AdminMapper {
    public List<AdminInfo> selectAll();

    public AdminInfo selectByName(String username);

    public int insertAdmin(AdminInfo admin);

    public int updateAdmin(AdminInfo admin);

    public int deleteAdmin(int id);
}
