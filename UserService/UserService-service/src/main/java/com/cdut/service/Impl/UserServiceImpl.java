package com.cdut.service.Impl;

import com.cdut.mapper.UserMapper;
import com.cdut.pojo.User;
import com.cdut.service.UserService;
import com.cdut.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public List<User> queryUsers() {
        return userMapper.findAll();
    }

    @Override
    public User findById(String user_id) {
        return userMapper.findById(user_id);
    }

    @Override
    public int deleteById(String user_id) {
        return userMapper.deleteById(user_id);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int deletelist(List delist) {
        return userMapper.deletelist(delist);
    }

    @Override
    public int add_user(User user) {
        return 0;
    }

    @Override
    public int delete_user(User user) {
        return 0;
    }

    @Override
    public User findByphoneNum(int phoneNum) { return userMapper.findByphoneNum(phoneNum); }
    @Override
    public List<User> show_users() {
        return userMapper.findAll();
    }

    @Override
    public User Sel(String user_id) {
        return userMapper.Sel(user_id);
    }

    @Override
    public User login(String user_name, String passwd) {
        return userMapper.login(user_name,passwd);
    }

    @Override
    public int register(User user) {
        return userMapper.register(user);
    }

    @Override
    public int validateLogin(User user) {
        List<User> userList = userMapper.findByName(user.getUser_name());
        for (User item:userList) {
            if (item.getPasswd().equals(user.getPasswd())){
                return Constants.LOGIN_SUCCESS;
            }
        }

        return Constants.LOGIN_ERROR_PASSWORD;
    }


}
