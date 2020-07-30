package com.cdut.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author fan
 * @package com.cdut.pojo
 * @date 2020/7/29 9:46
 */
public class UserHomework {
    private String uh_id;
    private String user_id;
    private String homework_id;
    private Integer homework_score;
    private Integer homework_status;
    private String homework_user_answer;
    private Timestamp homework_date;

    private String course_id;

    @Override
    public String toString() {
        return "UserHomework{" +
                "uh_id='" + uh_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", homework_id='" + homework_id + '\'' +
                ", homework_score=" + homework_score +
                ", homework_status=" + homework_status +
                ", homework_user_answer='" + homework_user_answer + '\'' +
                ", homework_date=" + homework_date +
                ", course_id='" + course_id + '\'' +
                '}';
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getUh_id() {
        return uh_id;
    }

    public void setUh_id(String uh_id) {
        this.uh_id = uh_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getHomework_id() {
        return homework_id;
    }

    public void setHomework_id(String homework_id) {
        this.homework_id = homework_id;
    }

    public Integer getHomework_score() {
        return homework_score;
    }

    public void setHomework_score(Integer homework_score) {
        this.homework_score = homework_score;
    }

    public Integer getHomework_status() {
        return homework_status;
    }

    public void setHomework_status(Integer homework_status) {
        this.homework_status = homework_status;
    }

    public String getHomework_user_answer() {
        return homework_user_answer;
    }

    public void setHomework_user_answer(String homework_user_answer) {
        this.homework_user_answer = homework_user_answer;
    }

    public Timestamp getHomework_date() {
        return homework_date;
    }

    public void setHomework_date(Timestamp homework_date) {
        this.homework_date = homework_date;
    }
}
