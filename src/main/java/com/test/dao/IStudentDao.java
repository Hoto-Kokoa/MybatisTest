package com.test.dao;

import com.test.domain.Emp;
import com.test.domain.Student;
import com.test.pojo.EmpAndDept;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IStudentDao {
    /**
     * 查询所有学生
     *
     * @return
     */
    List<Student> findAllStudent();

    List<Student> findOrderByName(String name);
    List<Student> findOrderByName1(@Param("name1") String name1, @Param("name2") String name2);
    int updateByName(Student student);

    int countName(Student student);

    int deleteById(Integer id);

    List<Student> RangeSelectById(Integer id);

    List<Student> SelectLike(String name);

    List<Student> testSqlIf(Student student);

    List<Student> list(Student student);


    @Select("select * from emp")
    List<Emp> findAllStudentAnnotate();

    @Select("select * from emp where id = #{id}")
    List<Emp> findEmpByIdAnnotate(Integer id);

    @Update("update emp set name = #{string} where id = #{id}")
    int  updateEmpNameAnnotate(@Param("id") Integer id, @Param("string") String string);

    @Delete("delete from emp where id = #{id}")
    int deleteEmpByIdAnnote(Integer id);

    @Select("select * from emp")
    @Results(
            id = "EmpAndDeptResults",
            value = {
                    @Result(column = "dept_id", property = "deptId"),
                    @Result(column = "name", property = "ename"),
                    @Result(column = "dept_id" ,property = "dept",
                            one = @One(
                            select = "com.test.dao.IEmpMapper.selectDept",
                                    fetchType = FetchType.LAZY
                    ))

            }

    )
    List<EmpAndDept> selectOneToOne();

}
