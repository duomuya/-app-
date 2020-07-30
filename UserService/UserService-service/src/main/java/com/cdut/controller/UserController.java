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
        Integer limit = (Integer)map.get("limit");
        List<User> u1 = userService.queryUsers();

        return Result.success(u1);

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
        return Result.success();

    }
    @RequestMapping("/update_user")
    @ResponseBody
    public Result update_user(@RequestBody Map<String, Object> map){
        int key = (Integer)map.get("key");
        String passwd = (String) map.get("uId");
        String email = (String) map.get("email");
        String passwd = (String) map.get("classId");
        String passwd = (String) map.get("departmentId");
        String key = (String) map.get("key");

        user= userService.findByphoneNum()


        user.setPasswd(email);

        return Result.success();

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
        String user_id = (String) map.get("delist");
        int su=userService.deletelist(delist);
        if(su!=0){
            return Result.success();
        }else {
            return Result.failure(USER_DELETE_ERROR);
        }
    }






}
