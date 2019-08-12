package com.test.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Emp {
    private Integer id;
    private Integer deptId;
    private String deptName;

    private String name;

    private Integer gender;
    private Double salary;
    private Double bonus;
    private String joinDate;
    private Integer mgr;

    private List<Integer> list;


}
