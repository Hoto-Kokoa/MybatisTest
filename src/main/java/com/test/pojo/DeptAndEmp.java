package com.test.pojo;

import com.test.domain.Emp;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


public class DeptAndEmp {
    private Integer id;
    private String name;
    private String loc;
    private List<Emp> list;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public List<Emp> getList() {
        return list;
    }

    public void setList(List<Emp> list) {
        this.list = list;
    }
}
