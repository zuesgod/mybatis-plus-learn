package com.zues.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zues.dao.UserDao;
import com.zues.entity.UserEntity;
import com.zues.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
}
