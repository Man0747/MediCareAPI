package com.medicare.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.medicare.model.UserModel;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<UserModel> findAll() {
        return jdbcTemplate.query("SELECT * FROM user", (rs, rowNum) ->
                new UserModel(
                        rs.getInt("User_Id"),
                        rs.getString("User_Email"),
                        rs.getString("User_Password"),
                        rs.getString("User_Role")
                ));
    }

    public UserModel findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM user WHERE User_Id = ?", new Object[]{id}, (rs, rowNum) ->
                new UserModel(
                        rs.getInt("User_Id"),
                        rs.getString("User_Email"),
                        rs.getString("User_Password"),
                        rs.getString("User_Role")
                ));
    }

    public UserModel findUserByEmail(String email) {
        return jdbcTemplate.queryForObject("SELECT * FROM user WHERE User_Email = ?", new Object[]{email}, (rs, rowNum) ->
                new UserModel(
                        rs.getInt("User_Id"),
                        rs.getString("User_Email"),
                        rs.getString("User_Password"),
                        rs.getString("User_Role")
                ));
    }

    public UserModel save(UserModel user) {


        user.setUser_Password(passwordEncoder.encode(user.getUser_Password()));
        int rowsAffected = jdbcTemplate.update(
                "INSERT INTO user (User_Email, User_Password, User_Role) VALUES (?, ?, ?)",
                user.getUser_Email(), user.getUser_Password(), user.getUser_Role()
        );

        // Optionally check if the insertion was successful
        if (rowsAffected > 0) {
            return user;
        } else {
            // Handle the case where the insert failed (e.g., throw an exception)
            throw new RuntimeException("Failed to insert user into the database");
        }
    }

}
