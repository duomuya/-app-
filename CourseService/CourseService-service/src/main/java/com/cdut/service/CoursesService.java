package com.cdut.service;

import com.cdut.pojo.Courses;
import com.cdut.pojo.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface CoursesService {
    List<Courses> queryAll();
    Courses queryById(String id);
    String addCourses(Courses courses);
    void updateCourses(Courses courses);
    void delById(String id);

    List<Courses> paging(int page, int num, String user_id);

    Result uploadCourses(HttpServletRequest request, MultipartFile[] courseVideos, String course_id) throws IOException;
    String getLiveUrl();

    int getCourseCount(String user_id);

    void batchDel(String[] course_idList);
}
