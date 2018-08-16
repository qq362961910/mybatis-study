package com.jy.mybatis.study.service;

import com.jy.mybatis.study.mybatis.mapper.SelectByIdMapper;

public interface BaseService<T, Dao extends SelectByIdMapper<T>> {

    T selectById(long id);

}
