package com.springapp.mvc.service;

/**
 * Created by WH on 2016/11/8.
 */
public interface UserService {
    public boolean checkUserExisted(String username);
    public boolean checkCorrect(String username, String password);
}
