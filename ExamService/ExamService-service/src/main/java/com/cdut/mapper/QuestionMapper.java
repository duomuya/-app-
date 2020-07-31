package com.cdut.mapper;

import com.cdut.pojo.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionMapper {

    /**
     * 通过id删除试卷
     * @param qId  id
     * @return 成功条数
     */
    int deleteByPrimaryKey(String qId);

    /**
     * 根据id删除课程
     * @param ids id列表
     * @return 删除条数
     */
    int batchDeleteByIds(List<String> ids);

    int insert(Question record);

    /**
     * 插入试题
     * @param record 试题实体
     * @return  成功条数
     */
    int insertSelective(Question record);

    /**
     * 通过主键查询
     * @param qId id
     * @return 试题实体
     */
    Question selectByPrimaryKey(String qId);

    /**
     * 根据id更新试题（会进行为空判定）
     * @param record question
     * @return 更新成功条数
     */
    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    /**
     * 查询所有
     * @return 试题列表
     */
    List<Question> selectAll();

    /**
     * 分页查询试题
     * @param page 处理后的页码
     * @param limit  每页数量
     * @return 试题列表
     */
    List<Question> selectByPage(@Param("page") int page, @Param("limit") int limit);

    /**
     * 查询总条数
     * @return 总条数
     */
    int selCount();
}