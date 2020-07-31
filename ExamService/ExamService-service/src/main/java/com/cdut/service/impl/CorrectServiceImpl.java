package com.cdut.service.impl;

import com.cdut.mapper.UPaperMapper;
import com.cdut.pojo.UPaper;
import com.cdut.service.CorrectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: CorrectServiceImpl
 *   * Author:   healer
 *   * Date:     2020/7/30 0:57
 *   * Description:
 *  
 */
@Service
public class CorrectServiceImpl implements CorrectService {
    @Autowired
    private UPaperMapper uPaperMapper;
    @Override
    public List<UPaper> queryByUid(String uid,int status, int page, int limit) {
        return uPaperMapper.selectByUid(uid,status,(page-1)*limit,limit);
    }

    @Override
    public int selCountById(String uid,int status) {
        return uPaperMapper.selectCountById(uid,status);
    }

    @Override
    public List<UPaper> queryByEid(String examId, int page, int limit) {
        return uPaperMapper.selectByEid(examId, (page-1)*limit, limit);
    }

    @Override
    public List<UPaper> queryByStatus(int status, int page, int limit) {
        return uPaperMapper.selectByStatus(status, (page-1)*limit, limit);
    }

    @Override
    public List<UPaper> queryByEidAndStatus(String examId, int status, int page, int limit) {
        return uPaperMapper.selectByEidAndStatus(examId, status, (page-1)*limit, limit);
    }

    @Override
    public int queryCountByEid(String examId) {
        return uPaperMapper.selectCountByEid(examId);
    }

    @Override
    public int queryCountByStatus(int status) {
        return uPaperMapper.selectCountByStatus(status);
    }

    @Override
    public int queryCountByEidAndStatus(String examId, int status) {
        return uPaperMapper.selectCountByEidAndStatus(examId, status);
    }

    @Override
    public int submitExam(UPaper uPaper) {
        return uPaperMapper.insertSelective(uPaper);
    }
}
