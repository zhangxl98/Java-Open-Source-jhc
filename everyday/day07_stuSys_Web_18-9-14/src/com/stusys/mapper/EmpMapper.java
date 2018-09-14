package com.stusys.mapper;

import com.stusys.pojo.Emp;

import java.util.List;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-11 上午9:40
 */
public interface EmpMapper {
    public List<Emp> selectAll();

    public int insertEmp(Emp emp);
}
