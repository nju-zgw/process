package com.springapp.mvc.dao;

import com.springapp.mvc.bean.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by H77 on 2016/11/7 0007.
 */
public interface UserDao {

    public boolean checkExistByName(String username);

    public User getUserByName(String username);

    public List<User> getUserList();

    public User getUserByUid(int uid);
}
