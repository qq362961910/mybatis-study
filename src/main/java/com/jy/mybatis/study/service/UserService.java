package com.jy.mybatis.study.service;

import com.jy.mybatis.study.entity.User;

public interface UserService {
    User queryUserById(long id);
}
