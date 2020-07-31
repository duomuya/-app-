package com.cdut.controller;

import com.cdut.pojo.UPaper;
import com.cdut.service.CorrectService;
import com.cdut.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;
import java.util.List;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: CorrectController
 *   * Author:   healer
 *   * Date:     2020/7/30 0:39
 *   * Description: 试卷批改相关业务
 *  
 */
@RestController
@RequestMapping("correct")
public class CorrectController {
    @Autowired
    private CorrectService correctService;

    @RequestMapping(value = "showUPaper", method = RequestMethod.GET)
    @ResponseBody
    public Result showAllByPage(String uid, int status, int page, int limit) {
        //老师的id
        List<UPaper> uPapers = correctService.queryByUid(uid, status, page, limit);
        int count = correctService.selCountById(uid, status);
        Object[] object = {uPapers, count};
        return Result.success(object);
    }

    @RequestMapping(value = "showUPaperByCondition", method = RequestMethod.GET)
    @ResponseBody
    public Result showByCondition(String examId, int status, int page, int limit) {
        if (examId != null && !examId.equals("")) {
            List<UPaper> uPapers = correctService.queryByEidAndStatus(examId, status, page, limit);
            int count = correctService.queryCountByEidAndStatus(examId, status);
            Object[] object = {uPapers, count};
            System.out.println(uPapers);
            return Result.success(object);
        } else {
            List<UPaper> uPapers = correctService.queryByStatus(status, page, limit);
            int count = correctService.queryCountByStatus(status);
            Object[] object = {uPapers, count};
            System.out.println(uPapers);
            return Result.success(object);
        }
    }

    public Result updateCorrect() {
        return null;
    }
}
