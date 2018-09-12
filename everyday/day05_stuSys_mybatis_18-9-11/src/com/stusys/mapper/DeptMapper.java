package com.stusys.mapper;

import com.stusys.pojo.Dept;

import java.util.List;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-11 上午9:29
 */
public interface DeptMapper {
    public List<Dept> selectAll();
    public Dept selectByName(String name);
    public Dept selectById(int id);
    public int insertDept(Dept dept);
    public int updateDept(Dept dept);
    public int deleteDept(int id);
}
