package com.cdut.controller;

import com.cdut.pojo.User;
import com.cdut.utils.MD5Utils;

public class UserController {
    private static String salt = "";

    /**
     * @param user: 匹配：前台的数据之间可以转成对象
     * @return
     *
     */
    public int Login(User user){
        //二次加盐
        String password = MD5Utils.setDBPwd(user.getPasswd(), salt);
        return 1;
    }

    public String reg(User user){
        String password = MD5Utils.setDBPwd(user.getPasswd(), salt);
        return "";
    }
}
