package com.jy.mybatis.study.service.impl;

import com.jy.mybatis.study.mybatis.mapper.CrudMapper;
import com.jy.mybatis.study.service.BaseService;

public abstract class BaseServiceImpl<T, Dao extends CrudMapper<T>> implements BaseService<T, Dao> {

    protected Dao dao;

    @Override
    public T selectById(long id) {
        return dao.selectById(id);
    }

    public BaseServiceImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void update(T t) {
        dao.updateById(t);
    }
}
