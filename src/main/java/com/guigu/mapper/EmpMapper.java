package com.guigu.mapper;

import com.guigu.mybatis.pojo.Emp;
import com.guigu.mybatis.pojo.EmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
    int countByExample(EmpExample example);

    int deleteByExample(EmpExample example);

    int deleteByPrimaryKey(Integer empId);

    int insert(Emp record);

    int insertSelective(Emp record);

    List<Emp> selectByExample(EmpExample example);

    Emp selectByPrimaryKey(Integer empId);

    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);


    // 根据主键查询员工并携带部门信息
    Emp selectByPrimaryKeyWithDept(Integer empId);

    // 根据条件查询所有员工并带有部门信息
    List<Emp> selectByExampleWithDept(EmpExample example);


}