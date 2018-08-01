package com.jy.mybatis.study.mybatis.mapper;

import com.jy.mybatis.study.mybatis.BaseSelectProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

public interface SelectByIdMapper<T> {

    @ResultMap("com.jy.mybatis.study.dao.UserDao.BaseResultMap")
    @SelectProvider(type = BaseSelectProvider.class, method = "selectById")
    T selectById(@Param("id") long id);
}
