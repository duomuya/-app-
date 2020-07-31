package com.cdut.pojo;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author fan
 * @package com.cdut.pojo
 * @date 2020/7/26 12:12
 */
public class Homework implements Serializable {
    private String homework_id;
    private String teacher_id;
    private String homework_content;
    private String homework_answer;
    private String course_id;
    private Date homework_deadline;

    //该属性便于页面获取课程名
    private String course_name;

    @Override
    public String toString() {
        return "Homework{" +
                "homework_id='" + homework_id + '\'' +
                ", teacher_id='" + teacher_id + '\'' +
                ", homework_content='" + homework_content + '\'' +
                ", homework_answer='" + homework_answer + '\'' +
                ", course_id='" + course_id + '\'' +
                ", homework_deadline=" + homework_deadline +
                ", course_name='" + course_name + '\'' +
                '}';
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public Date getHomework_deadline() {
        return homework_deadline;
    }

    public void setHomework_deadline(Date homework_deadline) {
        this.homework_deadline = homework_deadline;
    }

    public String getHomework_id() {
        return homework_id;
    }

    public void setHomework_id(String homework_id) {
        this.homework_id = homework_id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String course_name) {
        this.teacher_id = course_name;
    }

    public String getHomework_content() {
        return homework_content;
    }

    public void setHomework_content(String homework_content) {
        this.homework_content = homework_content;
    }

    public String getHomework_answer() {
        return homework_answer;
    }

    public void setHomework_answer(String homework_answer) {
        this.homework_answer = homework_answer;
    }
}
