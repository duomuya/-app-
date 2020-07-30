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
    public List<UserHomework> findByRequirement(UserHomework userHomework) {
        return userHomeworkMapper.findByRequirement(userHomework);
    }

    @Override
    public int update(UserHomework userHomework) {
        return userHomeworkMapper.update(userHomework);
    }

    @Override
    public int insert(UserHomework userHomework) {
        return userHomeworkMapper.insert(userHomework);
    }
}
