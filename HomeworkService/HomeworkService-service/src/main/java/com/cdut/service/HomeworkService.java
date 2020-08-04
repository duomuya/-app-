package com.cdut.service;

import com.cdut.pojo.Homework;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author fan
 * @package com.cdut.service
 * @date 2020/7/26 12:05
 */
public interface HomeworkService {
    public List<Homework> queryAll();
    public List<Homework> findByTeacherId(String uId, Integer page, Integer limit);
    public int deleteById(String id);
    public int insert(Homework homework);
    public int update(Homework homework);
    public int getCount(String uId);

    public List<Homework> findByCourseId(String cId);
}
