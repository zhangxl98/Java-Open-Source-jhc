package com.stusys.service;

import com.stusys.pojo.Dept;

import java.util.List;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-14 上午9:46
 */
public interface DeptService {
    public int addDept(Dept dept);

    public List<Dept> getAllDepts();

    public int delDept(int id);

    public Dept selectById(int deptid);

    public int editDept(Dept dept);
}
