package com.springapp.mvc.dao;

import com.springapp.mvc.bean.User;

import java.sql.SQLException;

/**
 * Created by H77 on 2016/11/7 0007.
 */
public interface userDao {
    public void insert(User user) throws SQLException;

    public void delete(User user) throws SQLException;

    public void modify(User user) throws SQLException;

    public User getUserById(long id) throws SQLException;

}
