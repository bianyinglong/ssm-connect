package com.guigu.mybatis.pojo;

public class Emp {
    private Integer empId;

    private String empName;

    private String empGender;

    private String empEmail;

    private Integer deptId;

    private Dept dept;



    public Emp() {
    }

    public Emp(String empName, String empGender, String empEmail, Integer deptId) {
        this.empName = empName;
        this.empGender = empGender;
        this.empEmail = empEmail;
        this.deptId = deptId;
    }

    public Emp(Integer empId, String empName, String empGender, String empEmail) {
        this.empId = empId;
        this.empName = empName;
        this.empGender = empGender;
        this.empEmail = empEmail;
    }


    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender == null ? null : empGender.trim();
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail == null ? null : empEmail.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empGender='" + empGender + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", deptId=" + deptId +
                ", dept=" + dept +
                '}';
    }
}