package com.mytest.mapper;

import com.mytest.Entries.Test;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TestMapper {
    @Select("select * from test where id=#{id}")
    Test selectById(@Param("id") int id);

    @Select("select id from test where id=#{id}")
    Integer selectId(@Param("id") int id);
}
