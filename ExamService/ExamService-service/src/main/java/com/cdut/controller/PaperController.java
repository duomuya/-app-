package com.cdut.controller;

import com.cdut.pojo.Paper;
import com.cdut.pojo.Paper_Q;
import com.cdut.service.PaperService;
import com.cdut.utils.Result;
import com.cdut.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *   * Copyright (C), 2020-2020, eduapp
 *   * FileName: PaperController
 *   * Author:   healer
 *   * Date:     2020/7/26 11:46
 *   * Description: 试卷信息controller
 *  
 */
@RestController
@RequestMapping("paper")
public class PaperController {
    @Autowired
    private PaperService paperService;

    @RequestMapping(value = "show_all_paper", method = RequestMethod.GET)
    @ResponseBody
    public Result showAll(String user_id) {
        List<Paper> papers = paperService.QueryAll(user_id);
        return Result.success(papers);
    }

    @RequestMapping(value = "show_my_by_page", method = RequestMethod.GET)
    @ResponseBody
    public Result showByPage(String uid, int page, int limit) {
        System.out.println(uid);
        List<Paper> papers = paperService.queryByPage(uid, page, limit);
        System.out.println(papers);
        int count = paperService.getCount(uid);
        Object[] object = {papers, count};
        return Result.success(object);
    }

    @RequestMapping(value = "add_paper", method = RequestMethod.POST)
    @ResponseBody
    public Result addPaper(@RequestBody Map<String, Object> map) {
        //获取数据
        String paperId = UUID.randomUUID().toString();
        String paperName = (String) map.get("paperName");
        String paperDes = (String) map.get("paperDes");
        String userId = (String) map.get("userId");
        //封装
        Paper paper = new Paper();
        paper.setPaperId(paperId);
        paper.setPaperDes(paperDes);
        paper.setPaperName(paperName);
        paper.setUserId(userId);
        int status = paperService.addPaper(paper);
        if (status <= 0) {
            return Result.failure(ResultCode.Paper_ADD_FAILED);
        } else {
            return Result.success();
        }
    }

    @RequestMapping(value = "update_paper", method = RequestMethod.POST)
    @ResponseBody
    public Result updatePaper(@RequestBody Map<String, Object> map) {
        //获取数据
        String paperId = (String) map.get("paperId");
        String paperName = (String) map.get("paperName");
        String paperDes = (String) map.get("paperDes");
        //封装
        Paper paper = new Paper();
        paper.setPaperId(paperId);
        paper.setPaperDes(paperDes);
        paper.setPaperName(paperName);
        int status = paperService.updatePaperById(paper);
        if (status <= 0) {
            return Result.failure(ResultCode.Paper_UPDATE_FAILED);
        } else {
            return Result.success();
        }
    }

    @RequestMapping(value = "delete_paper", method = RequestMethod.GET)
    @ResponseBody
    public Result deletePaper(String id) {
        int status = paperService.deletePaper(id);
        if (status <= 0) {
            return Result.failure(ResultCode.Paper_DELETE_FAILED);
        } else {
            return Result.success();
        }
    }

    @RequestMapping(value = "/batch_delete_paper", method = RequestMethod.POST)
    @ResponseBody
    public Result batchDeletePaper(@RequestBody Map<String, Object> map) {
        List<String> ids = (List<String>) map.get("delList");
        System.out.println("ids:"+ids);
        int status = paperService.batchDeletePaper(ids);
        if (status == ids.size()) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.Paper_BATCH_DELETE_FAILED);
        }
    }


    @RequestMapping(value = "add_paper_question", method = RequestMethod.POST)
    @ResponseBody
    public Result addPaperQuestion(@RequestBody Map<String, Object> map) {
        String pid = (String) map.get("pId");
        List<String> ids = (List<String>) map.get("qList");
        System.out.println("qid:"+pid);
        System.out.println("qList:"+ids);
        for (String item:ids) {
            Paper_Q paper_q = new Paper_Q();
            paper_q.setPaperId(pid);
            paper_q.setPqId(UUID.randomUUID().toString());
            paper_q.setQuestionId(item);
            paperService.addPaperQuestion(paper_q);
        }
        return Result.success();
    }
}
