package com.guigu.service.impl;import com.guigu.mapper.DeptMapper;import com.guigu.mybatis.pojo.Dept;import com.guigu.service.DeptService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import java.util.List;@Servicepublic class DeptServiceImp implements DeptService {    @Autowired    DeptMapper deptMapper;    @Override    public List<Dept> getAllDept() {        return deptMapper.selectByExample(null);    }    @Override    public Dept getDeptById(Integer id) {        return deptMapper.selectByPrimaryKey(id);    }    @Override    public boolean addDept(Dept dept) {        return deptMapper.insertSelective(dept) > 0;    }    @Override    public boolean deleteDept(Integer id) {        return deptMapper.deleteByPrimaryKey(id) > 0;    }    @Override    public boolean updateDeptInfo(Dept dept) {        return deptMapper.updateByPrimaryKeySelective(dept) > 0;    }}