package com.jy.mybatis.study.dao;

import com.jy.mybatis.study.entity.User;

public interface UserDao {
    User selectById(long id);
}
