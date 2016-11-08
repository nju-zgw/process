package com.springapp.mvc.dao;

import com.springapp.mvc.bean.User;

import java.sql.SQLException;

/**
 * Created by H77 on 2016/11/7 0007.
 */
public interface UserDao {
    public void insert(User user);

    public void delete(User user);

    public void modify(User user);

    public User getUserById(long id);

    public boolean checkExistByName(String username);

    public User getUserByName(String username);
}
