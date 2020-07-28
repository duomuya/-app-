package com.cdut.service;

import com.cdut.pojo.Exam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: ExamService
 *   * Author:   healer
 *   * Date:     2020/7/26 11:55
 *   * Description:
 *  
 */
public interface ExamService {
    /**
     * 根据id删除考试信息
     *
     * @param examId id
     * @return 成功条数
     */
    int deleteExamById(String examId);

    /**
     * 根据id列表批量删除
     *
     * @param ids id列表
     * @return 成功条数
     */
    int batchDeleteExamById(List<String> ids);

    /**
     * 添加考试信息
     * @param record exam
     * @return 插入成功条数
     */
    int addExam(Exam record);


    /**
     *修改考试信息
     * @param record exam
     * @return 更新成功条数
     */
    int updateExam(Exam record);

    /**
     * 分页查询
     * @param pageStart 起始页码
     * @param pageLimit 每页数量
     * @return 考试信息列表
     */
    List<Exam> getByPage(int pageStart,int pageLimit);

    /**
     * 根据id分页查询考试信息
     * @param id  用户id
     * @param pageStart   起始页码
     * @param pageLimit   每页数量
     * @return  某个用户的考试信息列表
     */
    List<Exam> getByUserId(String id, int pageStart, int pageLimit);

    /**
     * 根据id获得总条数
     * @return 总条数
     */
    int getCountById(String id);

    /**
     * 获取总考试信息数
     * @return 总记录数
     */
    int getAllCount();
}
