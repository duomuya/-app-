package com.cdut.mapper;

import com.cdut.pojo.UserHomework;
import com.cdut.utils.Result;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @author fan
 * @package com.cdut.mapper
 * @date 2020/7/29 10:11
 */
@Mapper
public interface UserHomeworkMapper {
    public List<UserHomework> queryAll();
    public List<UserHomework> findByRequirement(UserHomework userHomework);
    public int update(UserHomework userHomework);
    public int insert(UserHomework userHomework);
}
