package com.cdut.service;

import com.cdut.pojo.UserHomework;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author fan
 * @package com.cdut.service
 * @date 2020/7/29 16:42
 */
public interface UserHomeworkService {
    public List<UserHomework> queryAll();
    public List<UserHomework> findByRequirementByCourse(Integer page, Integer limit, String cId, Integer uhStatus, String uId);
    public List<UserHomework> findByRequirementByTeacher(Integer page, Integer limit, String uId, Integer uhStatus);
    public int update(UserHomework userHomework);
    public int insert(UserHomework userHomework);
    public int getCountByCourse(String cId, Integer uhStatus);
    public int getCountByTeacher(String uId, Integer uhStatus);
}
