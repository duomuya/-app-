package com.cdut.service;

import com.cdut.pojo.Question;

import java.util.List;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: QuestionService
 *   * Author:   healer
 *   * Date:     2020/7/26 11:56
 *   * Description:
 *  
 */
public interface QuestionService {
    /**
     * 通过id删除试题
     * @param qId  id
     * @return 成功条数
     */
    int deleteQuestion(String qId);

    /**
     * 根据id删除课程
     * @param ids id列表
     * @return 删除条数
     */
    int batchDeleteQuestion(List<String> ids);

    int insert(Question record);

    /**
     * 插入试题
     * @param record 试题实体
     * @return  成功条数
     */
    int addQuestion(Question record);

    /**
     * 通过主键查询
     * @param qId id
     * @return 试题实体
     */
    Question selectQuestionById(String qId);

    /**
     * 根据id更新试题（会进行为空判定）
     * @param record question
     * @return 更新成功条数
     */
    int updateQuestionById(Question record);

    int updateByPrimaryKey(Question record);

    /**
     * 查询所有
     * @return 试题列表
     */
    List<Question> queryAll();

    List<Question> queryByPage(int page,int limit);

    int getCount();

    Question getQuestionById(String qId);
}
