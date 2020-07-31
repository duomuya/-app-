package com.cdut.service;

import com.cdut.pojo.UPaper;

import java.util.List;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: CorrectService
 *   * Author:   healer
 *   * Date:     2020/7/30 0:57
 *   * Description:
 *  
 */
public interface CorrectService {
    List<UPaper> queryByUid(String uid,int status, int pageStart, int Limit);

    int selCountById(String uid,int status);

    List<UPaper> queryByEid(String examId, int page, int limit);

    //根据批改状态查询
    List<UPaper> queryByStatus(int status, int page, int limit);

    //根据批改状态和考试id查询
    List<UPaper> queryByEidAndStatus(String examId, int status, int page, int limit);

    //根据考试id查询总数
    int queryCountByEid(String examId);

    //根据批改状态查询总数
    int queryCountByStatus(int status);

    //根据批改状态和考试id查询总数
    int queryCountByEidAndStatus(String examId, int status);

    //提交试卷时插入
    int submitExam(UPaper uPaper);
}
