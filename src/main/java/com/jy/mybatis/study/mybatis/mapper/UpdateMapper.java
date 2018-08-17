package com.jy.mybatis.study.mybatis.mapper;

import com.jy.mybatis.study.mybatis.BaseUpdateProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface UpdateMapper<T> {

    @UpdateProvider(type = BaseUpdateProvider.class, method = "updateById")
    void updateById(final T t);

}
