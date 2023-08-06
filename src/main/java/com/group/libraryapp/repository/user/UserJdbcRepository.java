package com.group.libraryapp.repository.user;

import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isUserNotExist(long id){
        String sql = "select * FROM user where id = ?";
        return jdbcTemplate.query(sql,(rs,rowNum) -> 0,id).isEmpty();
    }

    public boolean isUserNotExist(String name){
        String sql = "select * FROM user where name = ?";
        return jdbcTemplate.query(sql,(rs,rowNum) -> 0, name).isEmpty();
    }

    public void updateUserName(String name, long id){
        String sql = "UPDATE user SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql,name,id);
    }

    public void deleteUserByName(String name){
        String sql = "DELETE FROM user WHERE name = ?";
        jdbcTemplate.update(sql,name);
    }

    public void saveUser(String name, Integer age){
        String sql = "INSERT INTO user(name,age) VALUES(?,?)";
        jdbcTemplate.update(sql,name,age);
    }

    public List<UserResponse> getUsersResponses(){
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, (rs,rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new UserResponse(id, name, age);
        });
    }
}
