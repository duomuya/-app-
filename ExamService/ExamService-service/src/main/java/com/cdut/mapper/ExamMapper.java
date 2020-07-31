package com.cdut.mapper;

import com.cdut.pojo.Exam;
import com.cdut.pojo.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ExamMapper {

    /**
     * 根据id删除考试信息
     *
     * @param examId id
     * @return 成功条数
     */
    int deleteByPrimaryKey(String examId);

    /**
     * 根据id列表批量删除
     *
     * @param ids id列表
     * @return 成功条数
     */
    int batchDeleteByPrimaryKey(List<String> ids);

    /**
     * 插入
     * @param record exam
     * @return 插入成功条数
     */
    int insert(Exam record);

    /**
     * 只将有值得进行插入
     * @param record exam
     * @return 插入成功条数
     */
    int insertSelective(Exam record);

    /**
     * 根据主键查询
     *
     * @param examId id
     * @return exam对象
     */
    Map<String,String> selectByPrimaryKey(String examId);

    /**
     * 根据主键进行非空更新
     *
     * @param record exam
     * @return 更新成功条数
     */
    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);

    /**
     * 分页查询
     *
     * @param pageStart 起始页码
     * @param pageLimit 每页数量
     * @return 考试信息列表
     */
    List<Exam> selectByPage(@Param("pageStart") int pageStart, @Param("pageLimit") int pageLimit);

    /**
     * 根据id分页查询考试信息
     * @param id  用户id
     * @param pageStart   起始页码
     * @param pageLimit   每页数量
     * @return  某个用户的考试信息列表
     */
    List<Exam> selectByUserId(@Param("userId") String id, @Param("pageStart") int pageStart, @Param("pageLimit") int pageLimit);

    /**
     * 根据用户id查询获取总条数
     * @param id user_id
     * @return 总条数
     */
    int selCount(String id);

    /**
     * 获取考试信息的总条数
     * @return 记录数
     */
    int selAllCount();

    /**
     * 根据课程id查询考试信息
     * @param cids  课程id
     * @return  map
     */
    List<Map<String,String>> showExamList(List<String> cids);

    List<Exam> showExamDesc(String examId);

    List<Question> getQuestions(String examId);

    List<Map<String,String>> getMineExam(String uid);

}