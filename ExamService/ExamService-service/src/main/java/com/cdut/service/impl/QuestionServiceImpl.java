package com.cdut.service.impl;

import com.cdut.mapper.QuestionMapper;
import com.cdut.pojo.Question;
import com.cdut.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: QuestionServiceImpl
 *   * Author:   healer
 *   * Date:     2020/7/26 14:20
 *   * Description:
 *  
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public int deleteQuestion(String qId) {
        return questionMapper.deleteByPrimaryKey(qId);
    }

    @Override
    public int batchDeleteQuestion(List<String> ids) {
        return questionMapper.batchDeleteByIds(ids);
    }

    @Override
    public int insert(Question record) {
        return 0;
    }

    @Override
    public int addQuestion(Question record) {
        return questionMapper.insertSelective(record);
    }

    @Override
    public Question selectQuestionById(String qId) {
        return questionMapper.selectByPrimaryKey(qId);
    }

    @Override
    public int updateQuestionById(Question record) {
        return questionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Question record) {
        return 0;
    }

    @Override
    public List<Question> queryAll() {
        return questionMapper.selectAll();
    }
}
