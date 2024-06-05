package com.zues;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zues.dao.UserDao;
import com.zues.entity.UserEntity;
import com.zues.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class CrudTestApplicationTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    /**
     * 测试crud
     */
    @Test
    void testCrud() {
        //列表
//        List<UserEntity> userEntities = userDao.selectList(new QueryWrapper<UserEntity>());
//        userEntities.forEach(System.out::println);
//        List<UserEntity> userEntities = userDao.selectList(new QueryWrapper<UserEntity>().like("name","zues"));
//        userEntities.forEach(System.out::println);
        //查询详情
//        UserEntity userEntity = userDao.selectById(10L);
//        System.out.println("detail = " + userEntity);

        //新增
//        UserEntity user = new UserEntity()
//                .setName("god")
//                .setAge(18);
//        int insert = userDao.insert(user);
//        System.out.println("insert = " + insert);
//        //可以直接获取ID
//        System.out.println("user = " + user);
        //修改
//        UserEntity updateUser = new UserEntity()
//                .setName("111")
//                .setAge(18)
//                .setId(1798357047176941569L);
//        int updated = userDao.updateById(updateUser);
//        System.out.println("updated = " + updated);

        //删除
//        int deleted = userDao.deleteById(1798357562853949441L);
//        System.out.println("deleted = " + deleted);

        //批量删除
//        List<Long> idList = Arrays.asList(7L, 8L, 9L);
//        int deleted = userDao.deleteBatchIds(idList);
//        System.out.println("deleted = " + deleted);

        //也可以使用service
//        List<UserEntity> list = userService.list();
//        list.forEach(System.out::println);

        //批量新增
//        List<UserEntity> userEntities = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            UserEntity user = new UserEntity()
//                    .setName("test" + i)
//                    .setAge(i);
//            userEntities.add(user);
//        }
//        boolean saveBatch = userService.saveBatch(userEntities);
//        System.out.println("saveBatch = " + saveBatch);

        //测试逻辑删除
//        boolean b = userService.removeById(1798361546645921802L);
//        System.out.println("b = " + b);
        //逻辑删除后查询会自动添加SELECT id,name,age,is_deleted FROM user WHERE id=? AND is_deleted=0 逻辑删除筛选条件
//        UserEntity userEntity = userService.getById(1798361546645921802L);
//        System.out.println("userEntity = " + userEntity);

    }

    /**
     * 测试条件查询
     */
    @Test
    void testQuery() {
        //有条件的查询
//        List<UserEntity> userEntityList = userDao.selectList(new QueryWrapper<UserEntity>()
//                .ge("age", 20)
//                .like("name", "林"));
//        userEntityList.forEach(System.out::println);

        //按年龄降序查询用户，如果年龄相同则按id升序排列
//        List<UserEntity> userEntityList = userDao.selectList(new QueryWrapper<UserEntity>().orderByDesc("age")
//                .orderByAsc("id"));
//        userEntityList.forEach(System.out::println);
    }
}
