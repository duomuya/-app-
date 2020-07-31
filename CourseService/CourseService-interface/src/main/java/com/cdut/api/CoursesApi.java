package com.cdut.api;

import com.cdut.pojo.Courses;
import com.cdut.pojo.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public interface CoursesApi {
    @RequestMapping(path = "/queryAll")
    public Result queryAll();

    @RequestMapping(path = "/queryById/{id}")
    public Result queryById(@PathVariable String id );

    @RequestMapping(path = "/add")
    public Result add(Courses courses);

    @RequestMapping(path = "/update")
    public Result update(Courses courses);
    @RequestMapping(path = "del/{id}")
    public Result del(@PathVariable String id);
    @RequestMapping(path = "courses/{page}/{num}")
    public Result paging(@PathVariable int page, @PathVariable int num);
}
