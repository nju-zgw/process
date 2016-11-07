package com.springapp.mvc.common.enums;

/**
 * Created by Administrator on 2016/11/7 0007.
 */
public enum RoleEnums {
    Manager("manager","项目主管"),
    Developer("developer","开发人员"),
    Tester("tester","测试人员"),
    Intern("intern","实习生");


    private String name;
    private String cname;
    RoleEnums(String name, String cname){
        this.name = name;
        this.cname = cname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
