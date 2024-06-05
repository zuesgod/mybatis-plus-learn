package com.zues.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zues.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
}
