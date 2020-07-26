package com.cdut.service.impl;

import com.cdut.mapper.HomeworkMapper;
import com.cdut.pojo.Homework;
import com.cdut.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fan
 * @package com.cdut.service.impl
 * @date 2020/7/26 12:06
 */
@Service
public class HomeworkServiceImpl implements HomeworkService{

    @Autowired(required = false)
    private HomeworkMapper homeworkMapper;

    @Override
    public List<Homework> queryAll() {
        return homeworkMapper.findAll();
    }

    @Override
    public Homework findById(String id) {
        return homeworkMapper.findById(id);
    }

    @Override
    public int deleteById(String id) {
        return homeworkMapper.deleteById(id);
    }

    @Override
    public int insert(Homework homework) {
        return homeworkMapper.insert(homework);
    }

    @Override
    public int update(Homework homework) {
        return homeworkMapper.update(homework);
    }
}
