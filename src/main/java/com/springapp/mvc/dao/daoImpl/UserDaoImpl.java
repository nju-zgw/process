package com.springapp.mvc.dao.daoImpl;

import com.springapp.mvc.bean.User;
import com.springapp.mvc.bean.mapper.UserRowMapper;
import com.springapp.mvc.dao.UserDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * Created by WH on 2016/11/8.
 */
@Repository("userDao")
public class UserDaoImpl extends JdbcDaoSupport implements UserDao{

    @Override
    public void insert(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void modify(User user) {

    }

    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public boolean checkExistByName(String username) {
        Integer cnt = this.getJdbcTemplate().queryForObject(
                "SELECT count(user_id) FROM users WHERE user_name=?", Integer.class, username);
        return cnt != null && cnt > 0;
    }

    @Override
    public User getUserByName(String username) {
        String sql = "select * from users where user_name=?";
        return this.getJdbcTemplate().queryForObject(sql, new UserRowMapper(),username);
    }
}
