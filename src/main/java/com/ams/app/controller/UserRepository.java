package com.ams.app.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ams.app.domain.User;

@Repository
public class UserRepository
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
 
    @Transactional(readOnly=true)
    public List<User> findAll() {
        return jdbcTemplate.query("select * from user", new UserRowMapper());
    }
}

class UserRowMapper implements RowMapper<User>
{
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException 
    {
        User user = new User();
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
 
        return user;
    }
}