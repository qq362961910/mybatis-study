package com.jy.mybatis.study.dao;

import com.jy.mybatis.study.dao.param.UserParam;
import com.jy.mybatis.study.entity.User;
import com.jy.mybatis.study.mybatis.mapper.SelectByIdMapper;

import java.util.List;

public interface UserDao extends SelectByIdMapper<User> {

    List<User> selectUserByParam(UserParam userParam);
}
