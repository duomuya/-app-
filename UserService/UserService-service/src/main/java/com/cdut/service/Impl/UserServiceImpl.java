package com.cdut.service.Impl;

import com.cdut.mapper.UserMapper;
import com.cdut.pojo.User;
import com.cdut.service.UserService;
import com.cdut.utils.Constants;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper;
//    boolean flag = false;


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

    @Transactional
    public int register(User user){
        return 1;
    }
}
