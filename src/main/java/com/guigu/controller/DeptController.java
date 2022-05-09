package com.guigu.controller;import com.github.pagehelper.PageHelper;import com.github.pagehelper.PageInfo;import com.guigu.mybatis.pojo.Dept;import com.guigu.mybatis.pojo.Emp;import com.guigu.service.DeptService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.*;import java.util.List;@RestController@CrossOrigin("*") // 设置跨域@RequestMapping("/dept")public class DeptController {    @Autowired    private DeptService deptService;    @GetMapping    public Result getAllDept() {        List<Dept> deptList = deptService.getAllDept();        Integer code = deptList != null ? Code.SUCCESS : Code.ERROR;        String msg = deptList != null ? "获取部门列表成功" : "获取部门列表失败";        return new Result(code, deptList, msg);    }    @GetMapping("/{id}")    public Result getDeptById(@PathVariable("id") Integer id) {        Dept dept = deptService.getDeptById(id);        Integer code = dept != null ? Code.SUCCESS : Code.ERROR;        String msg = dept != null ? "获取部门信息成功！" : "获取部门信息失败！";        return new Result(code, dept, msg);    }    // 一定要设置@RequestBody，表示前端传递的数据来自请求体    @PostMapping    public Result insertEmp(@RequestBody Dept dept) {        boolean flag = deptService.addDept(dept);        return new Result(flag ? Code.SUCCESS : Code.ERROR, flag);    }    @PutMapping("/{deptId}")    public Result updateEmp(@PathVariable Integer deptId, @RequestBody Dept dept) {        dept.setDeptId(deptId);        boolean flag = deptService.updateDeptInfo(dept);        return new Result(flag ? Code.SUCCESS : Code.ERROR, flag);    }    @DeleteMapping("/{id}")    public Result deleteDeptById(@PathVariable("id") Integer id) {        boolean flag = deptService.deleteDept(id);        return new Result(flag ? Code.SUCCESS : Code.ERROR, flag);    }}