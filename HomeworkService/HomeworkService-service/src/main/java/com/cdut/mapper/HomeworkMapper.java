package com.cdut.mapper;

import com.cdut.pojo.Homework;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author fan
 * @package com.cdut.mapper
 * @date 2020/7/26 12:18
 */
@Mapper
public interface HomeworkMapper {
    public List<Homework> findAll();
    public List<Homework> findById(String id);
    public int deleteById(String id);
    public int insert(Homework homework);
    public int update(Homework homework);
}
