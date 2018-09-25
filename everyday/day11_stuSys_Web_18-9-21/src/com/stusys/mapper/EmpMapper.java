package com.stusys.mapper;

import com.stusys.pojo.Emp;

import java.util.List;
import java.util.Map;

/**
 * @author zhangxiaoliang98
 * @Description
 * @date 18-9-11 上午9:40
 */
public interface EmpMapper {
    public List<Emp> selectAll();

    public List<Emp> selectBypage(Map map);

    public List<Emp> selectByWhere(Emp emp);

    public List<Emp> selectByWherePage(Map map);

    public Emp selectById(int id);

    public int insertEmp(Emp emp);

    public int delmany(int[] ids);

    public int selectCountByDept(int deptid);
}
