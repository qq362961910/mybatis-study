package com.jy.mybatis.study.service;

import com.jy.mybatis.study.mybatis.mapper.CrudMapper;

public interface BaseService<T, Dao extends CrudMapper<T>> {

    T selectById(long id);

    void update(T t);

}
