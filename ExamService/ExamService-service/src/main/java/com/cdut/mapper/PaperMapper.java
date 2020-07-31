package com.cdut.mapper;

import com.cdut.pojo.Paper;
import com.cdut.pojo.Paper_Q;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaperMapper {

    int deleteByPrimaryKey(String paperId);

    int batchDeleteByIds(List<String> ids);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(String paperId);

    int updateByPrimaryKeySelective(Paper record);

    List<Paper> selectAll(String user_id);

    List<Paper> selectByPage(@Param("userId") String uid, @Param("page") int page, @Param("limit") int limit);

    int selCount(String uid);

    int insertPaperQuestion(Paper_Q paper_q);

}