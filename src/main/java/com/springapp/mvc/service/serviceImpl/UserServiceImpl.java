package com.springapp.mvc.service.serviceImpl;

import com.springapp.mvc.bean.User;
import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public int getUserId(String username) {
        if(username == null || username.length() == -1){
            return -1;
        }
        User user = userDao.getUserByName(username);
        if(user !=null){
            return user.getId();
        }
        return -1;
    }

    @Override
    public String getUserNameById(int userid) {
      User user = userDao.getUserByUid(userid);
        if(user != null){
            return  user.getName();
        }
        return "º«Ææì÷";
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = userDao.getUserList();
        return userList;
    }
}
