package com.zues;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zues.dao.ProductDao;
import com.zues.dao.UserDao;
import com.zues.entity.ProductEntity;
import com.zues.entity.UserEntity;
import com.zues.enums.SexEnum;
import com.zues.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class CrudTestApplicationTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

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
        List<UserEntity> userEntityList = userDao.selectList(new QueryWrapper<UserEntity>()
                .ge("age", 20)
                .like("name", "林"));
        userEntityList.forEach(System.out::println);

        //按年龄降序查询用户，如果年龄相同则按id升序排列
//        List<UserEntity> userEntityList = userDao.selectList(new QueryWrapper<UserEntity>().orderByDesc("age")
//                .orderByAsc("id"));
//        userEntityList.forEach(System.out::println);


        /*
            子查询：
                查询id小于等于3的用户信息
         */
//        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
//        queryWrapper.inSql("id","select id from user where id < 10");
//        List<UserEntity> userEntityList = userDao.selectList(queryWrapper);
//        userEntityList.forEach(System.out::println);

    }

    /**
     * 定义可选的查询条件，有可能为null
     */
    @Test
    void testCondition(){
        String name = null;
        Integer age = 30;
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<UserEntity>()
                .like(StringUtils.isNotBlank(name), "name", name)
                .ge(age != null, "age", age);
        List<UserEntity> userEntityList = userDao.selectList(queryWrapper);
        userEntityList.forEach(System.out::println);
    }

    /**
     * LambdaQueryWrapper的使用
     */
    @Test
    void testLambdaQuery(){
        //定义查询条件，有可能为null
        String name = null;
        Integer age = 30;

        //LambdaQueryWrapper可以限制查询条件中任意编写的列字符，防止运行时错误
        LambdaQueryWrapper<UserEntity> lambdaQueryWrapper = new LambdaQueryWrapper<UserEntity>()
                .like(StringUtils.isNotBlank(name), UserEntity::getName, name)
                .ge(age != null, UserEntity::getAge, age);
        List<UserEntity> userEntityList = userDao.selectList(lambdaQueryWrapper);
        userEntityList.forEach(System.out::println);
    }


    /**
     * 测试LambdaUpdate条件表达式的编写
     */
    @Test
    void testLambdaUpdate(){
        //UPDATE user SET name=?,age=? WHERE is_deleted=0 AND (name LIKE ? AND (age < ?))
        LambdaUpdateWrapper<UserEntity> updateWrapper = new LambdaUpdateWrapper<UserEntity>()
                .set(UserEntity::getName, "zues")
                .set(UserEntity::getAge, 18)
                .like(UserEntity::getName, "god")
                .and(i -> i.lt(UserEntity::getAge, 24));
        UserEntity userEntity = new UserEntity();
        int update = userDao.update(userEntity, updateWrapper);
        System.out.println("受影响的行数： " + update);
    }


    /**
     * 测试分页插件
     */
    @Test
    void testPage() {
        //设置分页参数
        Page<UserEntity> page = new Page<UserEntity>(2, 5);
        Page<UserEntity> userEntityPage = userDao.selectPage(page, new QueryWrapper<>());

        List<UserEntity> records = userEntityPage.getRecords();
        records.forEach(System.out::println);
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示的条数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());
    }

    /**
     * 测试自定义分页
     */
    @Test
    void customerPage(){
        Page<UserEntity> userEntityPage = new Page<>(2, 5);
        Page<UserEntity> entityPage = userDao.selectPageByAge(userEntityPage, 10);
        List<UserEntity> records = entityPage.getRecords();
        records.forEach(System.out::println);
        System.out.println("当前页：" + entityPage.getCurrent());
        System.out.println("每页显示的条数：" + entityPage.getSize());
        System.out.println("总记录数：" + entityPage.getTotal());
        System.out.println("总页数：" + entityPage.getPages());
        System.out.println("是否有上一页：" + entityPage.hasPrevious());
        System.out.println("是否有下一页：" + entityPage.hasNext());
    }


    /**
     * 测试乐观锁：
     * 一件商品，成本价是80元，售价是100元。老板先是通知小李，说你去把商品价格增加50元。小
     * 李正在玩游戏，耽搁了一个小时。正好一个小时后，老板觉得商品价格增加到150元，价格太
     * 高，可能会影响销量。又通知小王，你把商品价格降低30元。
     * 此时，小李和小王同时操作商品后台系统。小李操作的时候，系统先取出商品价格100元；小王
     * 也在操作，取出的商品价格也是100元。小李将价格加了50元，并将100+50=150元存入了数据
     * 库；小王将商品减了30元，并将100-30=70元存入了数据库。是的，如果没有锁，小李的操作就
     * 完全被小王的覆盖了。
     * 现在商品价格是70元，比成本价低10元。几分钟后，这个商品很快出售了1千多件商品，老板亏1
     * 万多。
     */
    @Test
    void testOptimisticLock(){
//        //1.小李
//        ProductEntity p1 = productDao.selectById(1L);
//        System.out.println("小李取出的价格: " + p1.getPrice());
//
//        //2.小王
//        ProductEntity p2 = productDao.selectById(1L);
//        System.out.println("小王取出的价格: " + p2.getPrice());
//
//        //3、小李将价格加了50元，存入了数据库
//        p1.setPrice(p1.getPrice() + 50);
//        int insert = productDao.updateById(p1);
//        System.out.println("小李修改的结果: " + insert);
//
//        //4.小王将商品减了30元，存入数据库
//        p2.setPrice(p2.getPrice() - 30);
//        int insert2 = productDao.updateById(p2);
//        System.out.println("小王修改的结果: " + insert2);
//
//        //最后的结果
//        ProductEntity p3 = productDao.selectById(1L);
//        System.out.println("最后的结果: " + p3.getPrice());

        //优化流程

        //小李取数据
        ProductEntity p1 = productDao.selectById(1L);
        //小王取数据
        ProductEntity p2 = productDao.selectById(1L);

        //小李修改 +50
        p1.setPrice(p1.getPrice() + 50);
        int result1 = productDao.updateById(p1);
        System.out.println("小李修改的结果: " + result1);

        //小王修改 -30
        p2.setPrice(p2.getPrice() - 30);
        int result2 = productDao.updateById(p2);
        System.out.println("小王修改的结果: " + result2);
        if(result2 == 0){
            //失败重试，重新获取version并更新
            p2 = productDao.selectById(1L);
            p2.setPrice(p2.getPrice() - 30);
            result2 = productDao.updateById(p2);
            System.out.println("小王重试后的结果: " + result2);
        }

        //老板看价格
        ProductEntity p3 = productDao.selectById(1L);
        System.out.println("老板看价格： " + p3.getPrice());
    }

    /**
     * 测试通用枚举
     */
    @Test
    void testSexEnum(){
        UserEntity userEntity = new UserEntity()
                .setName("无名者")
                .setAge(22)
                //设置性别信息为枚举项，会将@EnumValue注解所标识的属性值存储到数据库
                .setSex(SexEnum.WOMEN.getSex());

        userDao.insert(userEntity);
    }
}
