package com.cdut.service;

import com.cdut.pojo.UserHomework;

import java.util.List;

/**
 * @author fan
 * @package com.cdut.service
 * @date 2020/7/29 16:42
 */
public interface UserHomeworkService {
    public List<UserHomework> queryAll();
    public List<UserHomework> findByRequirement(UserHomework userHomework);
    public int update(UserHomework userHomework);
    public int insert(UserHomework userHomework);
}
