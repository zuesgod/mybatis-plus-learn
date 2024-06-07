package com.zues.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zues.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

    /**
     * 根据年龄查询用户列表，分页显示
     * @param page 分页对象，xml中可以从里面进行取值，传递参数Page即自动分页，必须放到第一位
     * @param age 年龄
     * @return
     */
    Page<UserEntity> selectPageByAge(@Param("page") Page<UserEntity> page,@Param("age") Integer age);
}
