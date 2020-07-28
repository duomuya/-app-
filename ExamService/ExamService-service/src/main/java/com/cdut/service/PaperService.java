package com.cdut.service;

import com.cdut.pojo.Paper;

import java.util.List;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: PaperService
 *   * Author:   healer
 *   * Date:     2020/7/26 11:55
 *   * Description:
 *  
 */
public interface PaperService {
    int deletePaper(String paperId);

    int batchDeletePaper(List<String> ids);

    int addPaper(Paper record);

    Paper selectPaperById(String paperId);

    int updatePaperById(Paper record);

    List<Paper> QueryAll();
}
