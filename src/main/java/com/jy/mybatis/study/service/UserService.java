package com.jy.mybatis.study.service;

import com.jy.mybatis.study.dao.param.UserParam;
import com.jy.mybatis.study.entity.User;

import java.util.List;

public interface UserService {
    User queryUserById(long id);
    List<User> queryUserByParam(UserParam userParam);
}
