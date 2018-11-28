/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.jdbc.dao.impl;

import com.cibt.jdbc.core.JdbcTemplate;
import com.cibt.jdbc.core.RowMapper;
import com.cibt.jdbc.dao.UserDAO;
import com.cibt.web.entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USER
 */
public class UserDAOImpl implements UserDAO {

    JdbcTemplate<User> template = new JdbcTemplate<User>();

    public User login(String userName, String password) throws Exception {
        return template.queryForObject(
                "select * from users where username=?"
                        + " and password=?",
                new Object[]{userName,password},new UserMapper());
    }

    public boolean isEmailExists(String email) {
        return false;
    }

    public List<User> getAll() throws Exception {
        return template.query(
                "select * from users",
                new UserMapper()
        );
    }

    public User getById(int id) throws Exception {
        return template.queryForObject(
                "select * from users where id=?",
                new Object[]{id},new UserMapper());
    }

    private class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUserName(rs.getString("username"));
            user.setUserName(rs.getString("password"));
            return user;
        }
    }

}
