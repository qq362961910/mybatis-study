package com.jy.mybatis.study.service.impl;

import com.jy.mybatis.study.mybatis.mapper.SelectByIdMapper;
import com.jy.mybatis.study.service.BaseService;

public class BaseServiceImpl<T, Dao extends SelectByIdMapper<T>> implements BaseService<T, Dao> {

    protected Dao dao;

    @Override
    public T selectById(long id) {
        return dao.selectById(id);
    }

    public BaseServiceImpl(Dao dao) {
        this.dao = dao;
    }
}
