package com.test.dao;

import com.test.domain.Student;
import com.test.pojo.DeptAndEmp;

import java.util.List;

public interface IDeptMapper {
    /**
     * 根据id查询部门所有员工
     * @param id
     * @return
     */
    DeptAndEmp selectDeptAndEmpById(Integer id);

    List<Student> findOrderByName(String name);


}
