package com.medicare.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.medicare.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String FIND_BY_USERNAME_QUERY = "SELECT * FROM users WHERE username = ?";
    private static final String INSERT_USER_QUERY = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";

    public UserModel findByUsername(String username) {
        return jdbcTemplate.queryForObject(FIND_BY_USERNAME_QUERY, new Object[]{username}, new UserRowMapper());
    }

    public int save(UserModel user) {
        return jdbcTemplate.update(INSERT_USER_QUERY, user.getUser_Email(), user.getUser_Password(), user.getUser_Role());
    }

    private static final class UserRowMapper implements RowMapper<UserModel> {
        @Override
        public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        	UserModel user = new UserModel();
            user.setUser_Id(rs.getInt("user_id"));
            user.setUser_Email(rs.getString("user_email"));
            user.setUser_Password(rs.getString("user_password"));
            user.setUser_Role(rs.getString("user_role"));
            return user;
        }
    }
}
