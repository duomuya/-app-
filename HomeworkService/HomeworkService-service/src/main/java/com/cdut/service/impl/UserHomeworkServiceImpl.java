package com.cdut.service.impl;

import com.cdut.mapper.UserHomeworkMapper;
import com.cdut.pojo.UserHomework;
import com.cdut.service.UserHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fan
 * @package com.cdut.service.impl
 * @date 2020/7/29 16:46
 */
@Service
public class UserHomeworkServiceImpl implements UserHomeworkService {

    @Autowired(required = false)
    private UserHomeworkMapper userHomeworkMapper;

    @Override
    public List<UserHomework> queryAll() {
        return userHomeworkMapper.queryAll();
    }

    @Override
    public List<UserHomework> findByRequirementByCourse(Integer page, Integer limit, String cId, Integer uhStatus, String uId) {
        return userHomeworkMapper.findByRequirementByCourse(page, limit, cId, uhStatus, uId);
    }

    @Override
    public List<UserHomework> findByRequirementByTeacher(Integer page, Integer limit, String uId, Integer uhStatus) {
        return userHomeworkMapper.findByRequirementByTeacher(page, limit, uId, uhStatus);
    }

    @Override
    public int update(UserHomework userHomework) {
        return userHomeworkMapper.update(userHomework);
    }

    @Override
    public int insert(UserHomework userHomework) {
        return userHomeworkMapper.insert(userHomework);
    }

    @Override
    public int getCountByCourse(String cId, Integer uhStatus) {
        return userHomeworkMapper.getCountByCourse(cId, uhStatus);
    }

    @Override
    public int getCountByTeacher(String uId, Integer uhStatus) {
        return userHomeworkMapper.getCountByTeacher(uId, uhStatus);
    }
}
