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
    List<User> findAll();
    User findById(String user_id);
    int insert(User user);
    User Sel(String user_id);
    User login(String user_name,String passwd);
    int register(User user);

    int deleteById(String user_id);
    User findByphoneNum(int phoneNum);
    int count();
    int update(User user);
    int deletelist(List delist);
    int add_user(User user);
    int key_update(User user);
    List<User> pageQuery(int page,int size);
}
