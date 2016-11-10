package com.springapp.mvc.service;

import com.springapp.mvc.bean.User;

import java.util.List;

/**
 * Created by WH on 2016/11/8.
 */
public interface UserService {
    public boolean checkUserExisted(String username);
    public boolean checkCorrect(String username, String password);
    public int getUserId(String username);
    public String getUserNameById(int userid);
    public List<User> getAllUsers();
}
