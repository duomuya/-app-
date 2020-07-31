package com.cdut.mapper;

import com.cdut.pojo.Courses;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CoursesMapper {
    List<Courses> findAll();
    Courses findById(String id);
    void add(Courses courses);
    void update(Courses courses);
    void delById(String id);
    void updateVideoAddr(Courses courses);

    List<Courses> paging(@Param("page") int page, @Param("num") int num, @Param("user_id") String user_id);

    int getCourseCount(String user_id);
}
