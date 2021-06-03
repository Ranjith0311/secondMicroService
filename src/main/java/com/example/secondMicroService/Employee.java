package com.example.secondMicroService;

import org.springframework.context.annotation.Bean;

public class Employee {

    public Employee(Long empId, String empName, Long doj) {
        this.empId = empId;
        this.empName = empName;
        this.doj = doj;
    }

    public Employee(){}


    private Long empId;
    private String empName;

    public Long getDoj() {
        return doj;
    }

    public void setDoj(Long doj) {
        this.doj = doj;
    }

    private Long doj;

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }



}
