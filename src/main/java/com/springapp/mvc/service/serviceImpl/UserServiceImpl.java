package com.springapp.mvc.service.serviceImpl;

import com.springapp.mvc.bean.User;
import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by WH on 2016/11/8.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public boolean checkUserExisted(String username) {
        if(username == null || username.length() == 0){
            return false;
        }
        return userDao.checkExistByName(username);
    }

    @Override
    public boolean checkCorrect(String username, String password) {
        if(username == null || password == null){
            return  false;
        }
        if(username.length() == 0 || password.length() == 0) {
            return false;
        }
        User user = userDao.getUserByName(username);
        if(user.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }
}