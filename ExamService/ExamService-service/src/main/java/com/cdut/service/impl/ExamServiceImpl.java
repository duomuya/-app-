package com.cdut.service.impl;

import com.cdut.mapper.ExamMapper;
import com.cdut.pojo.Exam;
import com.cdut.pojo.Question;
import com.cdut.service.ExamService;
import org.bouncycastle.crypto.tls.UserMappingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: ExamServiceImpl
 *   * Author:   healer
 *   * Date:     2020/7/26 14:19
 *   * Description:
 *  
 */
@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamMapper examMapper;

    @Override
    public int deleteExamById(String examId) {
        return examMapper.deleteByPrimaryKey(examId);
    }

    @Override
    public int batchDeleteExamById(List<String> ids) {
        return examMapper.batchDeleteByPrimaryKey(ids);
    }

    @Override
    public int addExam(Exam record) {
        return examMapper.insertSelective(record);
    }

    @Override
    public int updateExam(Exam record) {
        return examMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Exam> getByPage(int pageStart, int pageLimit) {
        return examMapper.selectByPage((pageStart-1)*pageLimit,pageLimit);
    }

    @Override
    public List<Exam> getByUserId(String id, int pageStart, int pageLimit) {
        return examMapper.selectByUserId(id,(pageStart-1)*pageLimit,pageLimit);
    }

    @Override
    public int getCountById(String id) {
        return examMapper.selCount(id);
    }

    @Override
    public int getAllCount() {
        return examMapper.selAllCount();
    }

    @Override
    public List<Map<String,String>> showExamList(List<String> ids) {
        return examMapper.showExamList(ids);
    }

    @Override
    public Map<String,String> showExamDes(String examId) {
        return examMapper.selectByPrimaryKey(examId);
    }

    @Override
    public List<Question> getExamQuestion(String examId) {
        return examMapper.getQuestions(examId);
    }

    @Override
    public List<Map<String,String>> getMineExam(String uid) {
        return examMapper.getMineExam(uid);
    }
}
