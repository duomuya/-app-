package com.cdut.service;

import com.cdut.pojo.Homework;

import java.util.List;

/**
 * @author fan
 * @package com.cdut.service
 * @date 2020/7/26 12:05
 */
public interface HomeworkService {
    public List<Homework> queryAll();
    public List<Homework> findByTeacherId(String uId);
    public int deleteById(String id);
    public int insert(Homework homework);
    public int update(Homework homework);
}
