package com.mytest.dao;

import com.mytest.Entries.Log;
import org.apache.ibatis.annotations.*;

public interface LogDao extends BaseDao<Log> {
    @Select("select * from log")
    Log[] selectAll();

    @Select("select * from log where id=#{id}")
    Log select(@Param("id") int id);

    @Delete("delete from log where id=#{id}")
    void delete(@Param("id") int id);

    @Update("update log set #{key} = #{value} where id=${id}")
    void update(@Param("id") int id, @Param("key") String key, @Param("value") String value);

    @Insert("insert into log (personId,date,driverId,extra) values (#{personId},#{date},#{driverId},#{extra})")
    void create(Log object);
}