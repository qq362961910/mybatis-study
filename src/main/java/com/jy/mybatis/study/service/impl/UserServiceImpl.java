package com.jy.mybatis.study.service.impl;

import com.jy.mybatis.study.dao.UserDao;
import com.jy.mybatis.study.dao.param.UserParam;
import com.jy.mybatis.study.entity.User;
import com.jy.mybatis.study.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public User queryUserById(long id) {
        return userDao.selectById(id);
    }

    @Override
    public List<User> queryUserByParam(UserParam userParam) {
        return userDao.selectUserByParam(userParam);
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
}
