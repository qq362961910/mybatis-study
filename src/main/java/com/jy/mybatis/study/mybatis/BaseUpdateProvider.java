package com.jy.mybatis.study.mybatis;

import org.apache.ibatis.jdbc.SQL;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class BaseUpdateProvider {

    public String updateById(final Object obj) {
        Class<?> clazz = obj.getClass();
        Table table = clazz.getDeclaredAnnotation(Table.class);
        String tableName;
        if(table == null) {
            tableName = clazz.getSimpleName();
        } else {
            tableName = table.name();
        }
        Map<String, String> columnPropertyMapping = new HashMap<>();
        for (Field f: clazz.getDeclaredFields()) {
            Column columnAnno = f.getDeclaredAnnotation(Column.class);
            String column;
            if(columnAnno == null) {
                column = f.getName();
            } else {
                column = columnAnno.name();
            }
            columnPropertyMapping.put(column, f.getName());
        }
        SQL update = new SQL();
        update.UPDATE(tableName);
        columnPropertyMapping.forEach((k, v) -> update.SET(k + "=#{" + v + "}"));
        update.WHERE("id = #{id}");
        return update.toString();
    }

}
