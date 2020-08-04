package com.cdut.service.impl;

import com.cdut.mapper.HomeworkMapper;
import com.cdut.pojo.Homework;
import com.cdut.service.HomeworkService;
import com.cdut.utils.Constants;
import com.cdut.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fan
 * @package com.cdut.service.impl
 * @date 2020/7/26 12:06
 */
@Service
public class HomeworkServiceImpl implements HomeworkService{
    @Autowired
    private RedisUtil redisUtil;

    @Autowired(required = false)
    private HomeworkMapper homeworkMapper;

    @Override
    public List<Homework> queryAll() {
        return homeworkMapper.findAll();
    }

    @Override
    public List<Homework> findByTeacherId(String uId, Integer page, Integer limit) {
        return homeworkMapper.findById(uId, page, limit);
    }

    @Override
    public int deleteById(String id) {
//        boolean flag = redisUtil.hasKey(Constants.HOMEWORK_LIST);
//        if (flag){
//            //缓存中有数据
////            redisUtil.lPop(Constants.HOMEWORK_LIST);
//
//        }

        return homeworkMapper.deleteById(id);
    }

    @Override
    public int insert(Homework homework) {
        return homeworkMapper.insert(homework);
    }

    @Override
    public int update(Homework homework) {
        return homeworkMapper.update(homework);
    }

    @Override
    public int getCount(String uId) {
        return homeworkMapper.getCount(uId);
    }

    @Override
    public List<Homework> findByCourseId(String cId) {
        //从缓存中获取数据
//        List<Homework> list = null;
//        boolean flag = redisUtil.hasKey(Constants.HOMEWORK_LIST+cId);
//        if (flag){
//            //缓存中有数据
//            System.out.println("从缓存中取");
//            List<Object> lo = redisUtil.lGet(Constants.HOMEWORK_LIST+cId, 0, -1);
////            System.out.println("111");
//            list = (List<Homework>)(List)(lo.get(0));
////            list = list.get(0);
//            System.out.println(list);
//        }else {
//            //缓存中没数据
//            System.out.println("从数据库中取");
//            list = homeworkMapper.findByCourseId(cId);
//            if (list.size()!=0){
//                redisUtil.lSet(Constants.HOMEWORK_LIST+cId, list);
//            }
//        }
//        return list;
        return homeworkMapper.findByCourseId(cId);
    }
}
