package com.cdut.pojo;


import java.time.LocalDateTime;

public class Courses {
    private String course_id;
    private String course_name;
    private String course_date;
    private String course_desc;
    private String course_live;
    private String user_id;
    private String course_kind;

    public String getCourse_kind() {
        return course_kind;
    }

    public void setCourse_kind(String course_kind) {
        this.course_kind = course_kind;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_date() {
        return course_date;
    }

    public void setCourse_date(String course_date) {
        this.course_date = course_date;
    }

    public String getCourse_desc() {
        return course_desc;
    }

    public void setCourse_desc(String course_desc) {
        this.course_desc = course_desc;
    }

    public String getCourse_live() {
        return course_live;
    }

    public void setCourse_live(String course_live) {
        this.course_live = course_live;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "course_id='" + course_id + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_date='" + course_date + '\'' +
                ", course_desc='" + course_desc + '\'' +
                ", course_live='" + course_live + '\'' +
                ", user_id='" + user_id + '\'' +
                ", course_kind='" + course_kind + '\'' +
                '}';
    }
}
