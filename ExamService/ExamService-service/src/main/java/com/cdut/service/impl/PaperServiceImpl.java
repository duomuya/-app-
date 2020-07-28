package com.cdut.service.impl;

import com.cdut.mapper.PaperMapper;
import com.cdut.pojo.Paper;
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
    public List<Paper> QueryAll() {
        return paperMapper.selectAll();
    }
}
