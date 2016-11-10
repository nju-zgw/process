package com.springapp.mvc.service;

import com.springapp.mvc.bean.User;

import java.util.List;

/**
 * Created by WH on 2016/11/8.
 */
public interface UserService {
    public boolean checkUserExisted(String username);
    public boolean checkCorrect(String username, String password);
    public List<User> getAllUsers();
}
