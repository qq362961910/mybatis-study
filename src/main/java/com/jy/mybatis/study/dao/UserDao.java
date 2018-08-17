package com.jy.mybatis.study.dao;

import com.jy.mybatis.study.dao.param.UserParam;
import com.jy.mybatis.study.entity.User;
import com.jy.mybatis.study.mybatis.mapper.CrudMapper;

import java.util.List;

public interface UserDao extends CrudMapper<User> {

    List<User> selectUserByParam(UserParam userParam);
}
