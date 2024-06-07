package com.zues.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zues.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao extends BaseMapper<ProductEntity> {
}
