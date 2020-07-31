package com.cdut.mapper;

import com.cdut.pojo.UPaper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UPaperMapper {

    int deleteByPrimaryKey(String upId);

    int insert(UPaper record);

    int insertSelective(UPaper record);

    UPaper selectByPrimaryKey(String upId);

    int updateByPrimaryKeySelective(UPaper record);

    int updateByPrimaryKey(UPaper record);

    /**
     * 根据老师的uid分页查询所有考试的答卷
     *
     * @param uid 老师的uid
     * @return upaper实体
     */
    List<UPaper> selectByUid(@Param("uid") String uid, @Param("status") int status, @Param("pageStart") int pageStart, @Param("pageLimit") int pageLimit);

    int selectCountById(@Param("uid") String uid, @Param("status") int status);

    //根据考试id查询
    List<UPaper> selectByEid(@Param("examId") String examId, @Param("page") int page, @Param("limit") int limit);

    //根据批改状态查询
    List<UPaper> selectByStatus(@Param("status") int status, @Param("page") int page, @Param("limit") int limit);

    //根据批改状态和考试id查询
    List<UPaper> selectByEidAndStatus(@Param("examId") String examId, @Param("status") int status, @Param("page") int page, @Param("limit") int limit);

    //根据考试id查询总数
    int selectCountByEid(String examId);

    //根据批改状态查询总数
    int selectCountByStatus(int status);

    //根据批改状态和考试id查询总数
    int selectCountByEidAndStatus(@Param("examId") String examId, @Param("status") int status);
}