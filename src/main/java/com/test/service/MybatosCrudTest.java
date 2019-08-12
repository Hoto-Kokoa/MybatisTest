package com.test.service;

import com.test.dao.IDeptMapper;
import com.test.dao.IStudentDao;
import com.test.domain.Emp;
import com.test.domain.Student;
import com.test.pojo.DeptAndEmp;
import com.test.pojo.EmpAndDept;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatosCrudTest {

    private IStudentDao mapper;
    private InputStream resourceAsStream;
    private SqlSession session;
    private IDeptMapper iDeptMapper;

    @Before
    public void init() throws IOException {
        //读取配置文件
        resourceAsStream = Resources.getResourceAsStream("mybatisConfig.xml");
        //构建者模式:创建构建者对象sqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //使用构建者创建工厂对象
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        //使用工厂对象生产sqlSession对象
        session = build.openSession(true);
        //使用sqlsession对象创建一个dao口的代理对象
        mapper = session.getMapper(IStudentDao.class);
        iDeptMapper = session.getMapper(IDeptMapper.class);
    }

    @After
    public void destory() throws IOException {
    resourceAsStream.close();
     session.close();
    }
    @Test
     public void testSelectStudent()
     {
         //使用代理对象执行查询方法,List接受返回结果
         List<Student> allStudent = mapper.findAllStudent();
         //遍历结果
         for (Student student : allStudent) {
             System.out.println(student);
         }
     }

     @Test
    public void testFindOrderByName() {
        String name = "\"蕾米莉亚\""+","+"\"芙兰朵露\"";
//        String name1 = "\"";
        List<Student> allStudent = mapper.findOrderByName(name);

        for (Student student : allStudent) {
            System.out.println(student);
        }
    }
    @Test
    public void testFindOrderByName1() {
        String name1 = "蕾米莉亚";
        String name2 = "芙兰朵露";
        List<Student> allStudent = mapper.findOrderByName1( name1, name2);

        for (Student student : allStudent) {
            System.out.println(student);
        }
    }
    @Test
    public void testUpdateByName() {
        Student student = new Student();
        student.setName("蕾米莉亚");
        student.setAddress("红魔馆");
        int count = mapper.updateByName(student);
        System.out.println("更新数量为"+count);
    }
    @Test
    public void testCountName() {
        Student student = new Student();
        student.setName("蕾米莉亚");
        int count = mapper.countName(student);
        System.out.println(student.getName()+"的数量为"+count);

    }

    @Test
    public void testDeleteById() {
       Integer id = 944;
       int count = mapper.deleteById(id);
        System.out.println("删除返回值是"+count);
    }

    @Test
    public void testRangeSelectById() {
        int id = 950;
        List<Student> allStudent = mapper.RangeSelectById(id);
        for (Student student : allStudent) {
            System.out.println(student);
        }
    }

    @Test
    public void testSelectLike() {
        String name = "芙兰";
        List<Student> allStudent= mapper.SelectLike(name);
        for (Student student : allStudent) {
            System.out.println(student);
        }
    }
    @Test
    public void testTestSqlIf()
    {
        Student student = new Student();
//        student.setId(null);
        student.setName("芙兰朵露");
        List<Student> allStudent = mapper.testSqlIf(student);
        for (Student student1 : allStudent) {
            System.out.println(student1);
        }
    }

    @Test
    public void testtList()
    {
        Student student = new Student();
        List<Integer> list = new ArrayList();
        list.add(944);
        list.add(945);
        student.setList(list);
        List<Student> allStudent = mapper.list(student);
        for (Student student1 : allStudent) {
            System.out.println(student1);
        }
    }

    @Test
    public void testOneToMany()
    {
        Integer id = 1;
        DeptAndEmp deptAndEmp = iDeptMapper.selectDeptAndEmpById(id);
        for (Emp emp :
                deptAndEmp.getList()) {
            System.out.println(emp);
        }
//        List<Student> qino = iDeptMapper.findOrderByName("智乃");
//        for (Student student1 : qino) {
//            System.out.println(student1);
//        }
    }


    @Test
    public void testFindAllStudentAnnotate()
    {
        List<Emp> allStudentAnnotate = mapper.findAllStudentAnnotate();
        for (Emp emp : allStudentAnnotate)
        {
            System.out.println(emp);
        }
    }

    @Test
    public void testFindEmpByIdAnnotate()
    {
        List<Emp> empByIdAnnotate = mapper.findEmpByIdAnnotate(1);
        for (Emp emp : empByIdAnnotate)
        {
            System.out.println(emp);
        }
    }

    @Test
    public void testUpdateEmpNameAnnotate()
    {
        int i = mapper.updateEmpNameAnnotate(1, "孙猴子");
        System.out.println(i);
    }

    @Test
    public void testDeleteEmpByIdAnnotate()
    {
        int i = mapper.deleteEmpByIdAnnote(1);
        System.out.println(i);

    }

    @Test
    public void testSelectOneToOne()
    {
        List<EmpAndDept> empAndDepts = mapper.selectOneToOne();
        for (EmpAndDept empAndDept : empAndDepts)
        {
            System.out.println(empAndDept);
        }

        empAndDepts = mapper.selectOneToOne();
        for (EmpAndDept empAndDept : empAndDepts)
        {
            System.out.println(empAndDept);
        }
    }

}
