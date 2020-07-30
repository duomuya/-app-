package com.cdut.mapper;

import com.cdut.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
    *  根据用户名查询,再去匹配密码，区分用户名错误，还是密码错误
    * @param username
    * @return
    * */
    public List<User> findByName(String username);
}
