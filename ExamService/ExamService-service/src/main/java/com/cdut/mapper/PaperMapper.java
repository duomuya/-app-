package com.cdut.mapper;

import com.cdut.pojo.Paper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaperMapper {

    int deleteByPrimaryKey(String paperId);

    int batchDeleteByIds(List<String> ids);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(String paperId);

    int updateByPrimaryKeySelective(Paper record);

    List<Paper> selectAll();

}