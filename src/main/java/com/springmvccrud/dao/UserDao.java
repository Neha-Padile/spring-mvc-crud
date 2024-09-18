package com.springmvccrud.dao;

import com.springmvccrud.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserDao {
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveUser(User user){
        String save_query="INSERT INTO user (name,address,pincode) values (?,?,?)";
        jdbcTemplate.update(save_query, user.getName(), user.getAddress(),user.getPincode());
    }

    public List<User> getAllUser(){
        System.out.println("Inside UserDao getalluser");
        String update_query="SELECT * FROM user";
        return jdbcTemplate.query(update_query, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user=new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setAddress(resultSet.getString(3));
                user.setPincode(resultSet.getInt(4));
                return user;

            }
        });
    }

    public void deleteUser(int id){
        String DELETE_QUERY="DELETE FROM user WHERE id=?";
        jdbcTemplate.update(DELETE_QUERY,id);

    }


    public User editUser(int id){

        User user = new User();
        String EDIT_QUERY="select name,address,pincode FROM user WHERE id=?";
        jdbcTemplate.queryForObject(EDIT_QUERY,new Object[]{id}, new RowMapper<User>()  {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {

                user.setId(id);
                user.setName(rs.getString(1));
                user.setAddress(rs.getString(2));
                user.setPincode(rs.getInt(3));
                return user;
            }
        });
        return user;
    }

    public void updateUser(User user){
        String UPDATE_Query="UPDATE user SET name=?,address=?,pincode=? where id=?";
        jdbcTemplate.update(UPDATE_Query,user.getName(),user.getAddress(),user.getPincode(),user.getId());

    }

}
