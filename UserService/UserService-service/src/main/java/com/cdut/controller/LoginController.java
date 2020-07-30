package com.cdut.controller;

import com.cdut.pojo.User;
import com.cdut.service.UserService;
import com.cdut.utils.MD5Utils;
import com.cdut.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

import static com.cdut.utils.ResultCode.*;


@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
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


    @RequestMapping("/loginUser")
    @ResponseBody
    public Result loginValidate(@RequestBody Map<String, Object> map){
        int phoneNum = (Integer)map.get("account");
        String passwd = (String) map.get("password");
        User u1 = userService.findByphoneNum(phoneNum);
        if (u1==null){
            return Result.failure( USER_NOT_EXIST);
        }else {
            if(passwd!=u1.getPasswd()){
                return Result.failure(USER_LOGIN_ERROR);
            }
            else {
                if (u1.getKey()==3){
                    return Result.failure(USER_NOT);
                }else {
                    return Result.success();
                }
            }
        }
    }
    @RequestMapping("/register")
    @ResponseBody
    public Result registValidate(@RequestBody Map<String, Object> map){
        String user_id = UUID.randomUUID().toString();
        int phoneNum = (Integer)map.get("account");
        String passwd = (String) map.get("password");
        int key =3;
        User user = new User();
        user.setUser_id(user_id);
        user.setPhoneNum(phoneNum);
        user.setPasswd(passwd);
        user.setKey(key);

        if(phoneNum== userService.findByphoneNum(phoneNum).getPhoneNum()){
            return Result.failure(USER_HAS_EXIST);
        }else {
            int su = userService.register(user);
            if(su!=0){
                return Result.success();
            }else {
                return Result.failure(USER_REGISTER_FAILED);
            }

        }
    }

    @RequestMapping("/resetPass")
    @ResponseBody
    public Result resetPass(@RequestBody Map<String, Object> map){
        int phoneNum = (Integer)map.get("account");
        String newpasswd = (String) map.get("newPass");
        if(phoneNum== userService.findByphoneNum(phoneNum).getPhoneNum()){
            return Result.failure(USER_HAS_EXIST);
        }else {
            User u1 = userService.findByphoneNum(phoneNum);
            u1.setPasswd(newpasswd);
            return Result.success();
        }
    }

    @RequestMapping("/alterUserInfo")
    @ResponseBody
    public Result alterUserInfo(@RequestBody Map<String, Object> map){
        String user_name = (String) map.get("user_name");
        String department_name = (String) map.get("department_name");
        String email = (String) map.get("email");
        int phoneNum = (Integer)map.get("phoneNum");
        User u1 = userService.findByphoneNum(phoneNum);
        u1.setUser_name(user_name);
        u1.setDepartment_name(department_name);
        u1.setEmail(email);
        int su=userService.update(u1);
        if(su!=0){
            return Result.success();
        }else {
            return Result.failure(USER_UPDATE_ERROR);
        }
    }
    @RequestMapping("/alterUserPass")
    @ResponseBody
    public Result alterUserPass(@RequestBody Map<String, Object> map){
        String oldpasswd = (String) map.get("oldPass");
        String newpasswd = (String) map.get("newPass");
        int phoneNum = (Integer)map.get("account");
        User u1 = userService.findByphoneNum(phoneNum);
        if(u1.getPasswd()!=oldpasswd){
            return Result.failure(USER_LOGIN_ERROR);
        }else{
            u1.setPasswd(newpasswd);
            return Result.success();
        }

    }
    @RequestMapping("/alterUserAvatar")
    @ResponseBody
    public Result alterUserAvatar(@RequestBody Map<String, Object> map){
        String headImg = (String) map.get("avatarImg");
        int phoneNum = (Integer)map.get("account");
        User u1 = userService.findByphoneNum(phoneNum);
        u1.setHeadImg(headImg);
        return Result.success();

    }



    //跳转首页（登录页）
//    @RequestMapping("/")
//    public String show(){
//        return "index";
//    }

    //登录操作
//    @ResponseBody
//    @RequestMapping("/loginUser")
//    public String login(User user, HttpServletRequest request){
//
//        String user_name = user.getUser_name();
//        String passwd = user.getPasswd();
//        User u1 =userService.login(user_name,passwd);
//        if (u1==null){
//            return "用户名或密码错误";
//        }else{
//            request.getSession().setAttribute("session_user",user);//登录成功后将用户放入session中，用于拦截
//
//            return "welcome";
//        }
//    }

    //跳转注册页
//    @RequestMapping("/toRegister")
//    public String toRegister(){
//        return "register";
//    }

    //注册操作
//    @RequestMapping("/register")
//    public String register(User user){
//        String user_id = UUID.randomUUID().toString();
//        user.setUser_id(user_id);
//        int su = userService.register(user);
//        if(su==0){
//            System.out.println("----");
//        }
//        return "welcome";
//    }

    //测试未登陆拦截页面
//    @RequestMapping("/welcome")
//    public String welcome(){
//        return "welcome";
//    }

//    //退出登录
//    @RequestMapping("/toOut")
////    public void outUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
////        request.getSession().removeAttribute("session_user");
////        response.sendRedirect("/out");
////    }
//    private String toout() {
//        return "index";
//        //return "out";
//    }


}
