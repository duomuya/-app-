package com.cdut.controller;

import com.cdut.pojo.User;
import com.cdut.service.UserService;
import com.cdut.utils.MD5Utils;
import com.cdut.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.cdut.utils.ResultCode.*;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/show_Users")
    @ResponseBody
    public Result show_Users(@RequestBody Map<String, Object> map){
        Integer page = (Integer) map.get("page");
        Integer size = (Integer)map.get("limit");
        List<User> u1 = userService.pageQuery(page, size);
        if(u1!=null){
            return Result.success(u1);
        }else {
            return Result.failure(USER_QUERY_ERROR);
        }


    }
    @RequestMapping("/add_user")
    @ResponseBody
    public Result add_user(@RequestBody Map<String, Object> map){
        String user_id = UUID.randomUUID().toString();
        int phoneNum = (Integer)map.get("telephone");
        String passwd = (String) map.get("password");
        int key = (Integer)map.get("key");
        String user_name = (String) map.get("username");
        String email = (String) map.get("email");

        User user = new User();
        user.setUser_id(user_id);
        user.setPhoneNum(phoneNum);
        user.setPasswd(passwd);
        user.setEmail(email);
        user.setUser_name(user_name);
        user.setKey(key);
        int su=userService.add_user(user);
        if(su!=0){
            return Result.success();
        }else {
            return Result.failure(USER_INSERT_ERROR);
        }
    }
    @RequestMapping("/update_user")
    @ResponseBody
    public Result update_user(@RequestBody Map<String, Object> map){
        int key = (Integer)map.get("key");
        String user_name = (String) map.get("user_name");
        int phoneNum = (Integer) map.get("phoneNum");
        String email = (String) map.get("email");
        String class_name = (String) map.get("class_name");
        String department_name = (String) map.get("department_name");

        User u1= userService.findByphoneNum(phoneNum);
        u1.setEmail(email);
        u1.setUser_name(user_name);
        u1.setPasswd(email);
        u1.setDepartment_name(department_name);
        u1.setClass_name(class_name);
        u1.setKey(key);
        int su=userService.key_update(u1);
        if(su!=0){
            return Result.success();
        }else {
            return Result.failure(USER_UPDATE_ERROR);
        }
    }
    @RequestMapping("/delete_user")
    @ResponseBody
    public Result delete_user(@RequestBody Map<String, Object> map){
        String user_id = (String) map.get("uId");
        int su=userService.deleteById(user_id);
        if(su!=0){
            return Result.success();
        }else {
            return Result.failure(USER_DELETE_ERROR);
        }
    }
    @RequestMapping("/batch_delete_user")
    @ResponseBody
    public Result batch_delete_user(@RequestBody Map<String, Object> map){
        List delist = (List) map.get("delist");
        int su=userService.deletelist(delist);
        if(su!=0){
            return Result.success();
        }else {
            return Result.failure(USER_DELETE_ERROR);
        }
    }






}
