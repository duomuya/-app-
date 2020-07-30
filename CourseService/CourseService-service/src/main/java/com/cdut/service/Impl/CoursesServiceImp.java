package com.cdut.service.Impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.cdut.mapper.CoursesMapper;
import com.cdut.pojo.Courses;
import com.cdut.pojo.Result;
import com.cdut.service.CoursesService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.UUID;

@Service
public class CoursesServiceImp implements CoursesService {
    @Autowired
    CoursesMapper coursesMapper;
    @Override
    public List<Courses> queryAll() {
        return coursesMapper.findAll();
    }

    @Override
    public Courses queryById(String id) {
        return coursesMapper.findById(id);
    }

    @Override
    public String addCourses(Courses courses) {
        courses.setCourse_id(UUID.randomUUID().toString());

        if(courses.getCourse_kind().equals("直播")){
            courses.setCourse_live(getLiveUrl());
        }else{
            JSONObject course_live=new JSONObject();
            courses.setCourse_live(course_live.put("addrList",new JSONArray()).toString());
        }
        coursesMapper.add(courses);
        return courses.getCourse_live();
    }

    @Override
    public void updateCourses(Courses courses) {
        Courses newCourses=coursesMapper.findById(courses.getCourse_id());
        newCourses.setCourse_name(courses.getCourse_name());
        newCourses.setCourse_desc(courses.getCourse_desc());
        newCourses.setCourse_date(courses.getCourse_date());
        coursesMapper.update(newCourses);
    }

    @Override
    public void delById(String id) {
        coursesMapper.delById(id);
    }

    @Override
    public List<Courses> paging(int page, int num, String user_id) {
        return coursesMapper.paging((page-1)*num, num, user_id);
    }



    @Override
    public Result uploadCourses(HttpServletRequest request, MultipartFile[] courseVideos, String course_id) throws IOException {
        String path = ResourceUtils.getURL("classpath:static/coursesVideo").getPath()+"/"+course_id;
        String visitPath = "http://"+ InetAddress.getLocalHost().getHostAddress() +":10010/eduapp/courseservice/coursesVideo/"+course_id+"/";
        System.out.println(path);
        Courses courses=coursesMapper.findById(course_id);
        JSONObject addrListJson=new JSONObject(courses.getCourse_live());
        JSONArray addrList= (JSONArray) addrListJson.get("addrList");

        for(int i=0;i<courseVideos.length;i++){
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            JSONObject addr=new JSONObject();
            String fileName=courseVideos[i].getOriginalFilename();
            courseVideos[i].transferTo(new File(file,fileName));
            addr.put("chapterName",fileName);
            addr.put("url",visitPath+fileName);
            addrList.put(addr);
        }

        System.out.println(addrList);
        courses.setCourse_live(addrListJson.put("addrList",addrList).toString());
        coursesMapper.updateVideoAddr(courses);
        return Result.success();
    }

    @Override
    public String getLiveUrl() {
        return "http://120.27.244.91:80/hls/"+UUID.randomUUID().toString()+".m3u8";
    }

    @Override
    public int getCourseCount(String user_id) {
        return coursesMapper.getCourseCount(user_id);
    }

    @Override
    public void batchDel(String[] course_idList) {
        for(String course_id:course_idList){
            delById(course_id);
        }
    }


}
