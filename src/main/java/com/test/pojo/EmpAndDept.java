package com.test.pojo;

import com.test.domain.Dept;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmpAndDept {
    private Integer id;
    private Integer jobId;
    private Integer deptId;

    private String ename;
    private String deptName;
    private Integer gender;
    private Double salary;
    private Double bonus;
    private String joinDate;
    private Integer mgr;

    private Dept dept;
    // 部门名称
    // private String deptName;
    // 部门所在地
    // private String deptLoc;

}
