package com.mytest.dao;

import com.mytest.Entries.Driver;
import org.apache.ibatis.annotations.*;

public interface DriverDao extends BaseDao<Driver> {
    @Select("select * from driver")
    Driver[] selectAll();

    @Select("select * from driver where id=#{id}")
    Driver select(@Param("id") int id);

    @Delete("delete from driver where id=#{id}")
    void delete(@Param("id") int id);

    @Update("update driver set ${key} = #{value} where id=${id}")
    void update(@Param("id") int id, @Param("key") String key, @Param("value") String value);

    @Insert("insert into driver (name,officeId,buyDate,inspectionTimes,line,extra) values (#{name},#{officeId},#{buyDate},#{inspectionTimes},#{line},#{extra})")
    void create(Driver object);
}