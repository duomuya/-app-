package com.cdut.service.impl;

import com.cdut.mapper.PaperMapper;
import com.cdut.pojo.Paper;
import com.cdut.pojo.Paper_Q;
import com.cdut.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: PaperServiceImpl
 *   * Author:   healer
 *   * Date:     2020/7/26 14:19
 *   * Description:
 *  
 */
@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    PaperMapper paperMapper;
    @Override
    public int deletePaper(String paperId) {
        return paperMapper.deleteByPrimaryKey(paperId);
    }

    @Override
    public int batchDeletePaper(List<String> ids) {
        return paperMapper.batchDeleteByIds(ids);
    }

    @Override
    public int addPaper(Paper record) {
        return paperMapper.insertSelective(record);
    }

    @Override
    public Paper selectPaperById(String paperId) {
        return paperMapper.selectByPrimaryKey(paperId);
    }

    @Override
    public int updatePaperById(Paper record) {
        return paperMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Paper> QueryAll(String user_id) {
        return paperMapper.selectAll(user_id);
    }

    @Override
    public List<Paper> queryByPage(String uid, int page, int limit) {
        return paperMapper.selectByPage(uid,(page-1)*limit,limit);
    }

    @Override
    public int getCount(String uid) {
        return paperMapper.selCount(uid);
    }

    @Override
    public int addPaperQuestion(Paper_Q paper_q) {
        return paperMapper.insertPaperQuestion(paper_q);
    }
}
