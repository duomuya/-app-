package com.cdut.service;

import com.cdut.pojo.User;

import java.util.List;

public interface UserService {
    public int validateLogin(User user);

    public  User findById(String user_id);
    public int deleteById(String user_id);
    public int insert(User user);

    public int delete_user(User user);
    public List<User> show_users();
    public User Sel(String user_id);
    public User login(String user_name, String passwd);

    public List<User> queryUsers();
    public User findByphoneNum(int phoneNum);
    public int register(User user);
    public int update(User user);
    public int deletelist(List delist);
    public int add_user(User user);
    public int key_update(User user);
    public List<User> pageQuery(int page,int size);
}
