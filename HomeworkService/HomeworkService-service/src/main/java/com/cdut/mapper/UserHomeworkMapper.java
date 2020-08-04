package com.cdut.mapper;

import com.cdut.pojo.UserHomework;
import com.cdut.utils.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    public List<UserHomework> findByRequirementByTeacher(@Param("page") Integer page,
                                                         @Param("limit") Integer limit,
                                                         @Param("uId") String uId,
                                                         @Param("uhStatus") Integer uhStatus);
    public List<UserHomework> findByRequirementByCourse(@Param("page") Integer page,
                                                        @Param("limit") Integer limit,
                                                        @Param("cId") String cId,
                                                        @Param("uhStatus") Integer uhStatus,
                                                        @Param("uId") String uId);
    public int update(UserHomework userHomework);
    public int insert(UserHomework userHomework);
    public int getCountByCourse(@Param("cId") String cId, @Param("uhStatus") Integer uhStatus);
    public int getCountByTeacher(@Param("uId") String uId, @Param("uhStatus") Integer uhStatus);
}
