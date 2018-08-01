package com.jy.mybatis.study.mybatis;

import org.apache.ibatis.annotations.Param;

public class BaseSelectProvider {

    public static String selectById(@Param("id") final long id) {
        return "select * from user where id=#{id}";
    }

}
