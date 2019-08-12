package com.test.dao;

import com.test.domain.Dept;
import com.test.domain.Emp;
import com.test.pojo.*;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface IEmpMapper {
    List<Emp> selectEmpByIf (Emp emp);

    /**
     * 查询员工及部门信息
     * @return
     */
    List<EmpAndDept> selectEmpAndDeptInfo();

    @Select("select * from dept where id = #{id}")
    @Results(value =
            {
                    @Result(column = "name", property = "deptName")
            })
    Dept selectDept(Integer id);
}
