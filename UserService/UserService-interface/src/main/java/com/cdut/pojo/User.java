package com.cdut.pojo;

import java.io.Serializable;

public class User implements Serializable {

    private String user_id;
    private String user_name;
    private int phoneNum;
    private String email;
    private String passwd;
    private String department_name;
    private String class_name;
    private int key;
    private String headImg;

    public User(){

    }

    public User(String user_id , String user_name, int phoneNum, String email, String passwd, String department_name, String class_name, int key, String headImg) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.passwd = passwd;
        this.department_name = department_name;
        this.class_name = class_name;
        this.key = key;
        this.headImg = headImg;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                ", department_name='" + department_name + '\'' +
                ", class_name='" + class_name + '\'' +
                ", key='" + key + '\'' +
                ", headImg='" + headImg + '\'' +
                '}';
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}
