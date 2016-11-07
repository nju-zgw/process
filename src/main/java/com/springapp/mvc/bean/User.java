package com.springapp.mvc.bean;

/**
 * Created by H77 on 2016/11/7 0007.
 */
public class User {

    //1.用户： 账号、密码、姓名、角色类别（主管、开发人员、实习生）、个人简介、用户编号（主键）
    private long id;
    private String account;
    private String password;
    private String name;
    private String type;
    private String content;


    public User(long id, String account, String password, String name, String type, String content) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.type = type;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



}
