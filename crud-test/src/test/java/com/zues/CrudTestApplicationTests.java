package com.zues;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zues.dao.UserDao;
import com.zues.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CrudTestApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
    }

    @Test
    void testCrud(){
        //列表
        List<UserEntity> userEntities = userDao.selectList(new QueryWrapper<UserEntity>());
        userEntities.forEach(System.out::println);
//        List<UserEntity> userEntities = userDao.selectList(new QueryWrapper<UserEntity>().like("name","zues"));
//        userEntities.forEach(System.out::println);
        //查询详情
//        UserEntity userEntity = userDao.selectById(10L);
//        System.out.println("detail = " + userEntity);

        //新增

        //修改

        //删除

        //批量删除

    }
}
