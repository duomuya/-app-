package com.cdut.pojo;

import java.io.Serializable;

/**
 * @author fan
 * @package com.cdut.pojo
 * @date 2020/7/26 12:12
 */
public class Homework implements Serializable {
    private String homework_id;
    private String course_name;
    private String homework_content;
    private String homework_answer;

    @Override
    public String toString() {
        return "Homework{" +
                "homeworkId=" + homework_id +
                ", courseName='" + course_name + '\'' +
                ", homeworkContent='" + homework_content + '\'' +
                ", homeworkAnswer='" + homework_answer + '\'' +
                '}';
    }

    public String getHomework_id() {
        return homework_id;
    }

    public void setHomework_id(String homework_id) {
        this.homework_id = homework_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
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
