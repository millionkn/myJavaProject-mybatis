package com.mytest.dao;

import com.mytest.Entries.Office;
import org.apache.ibatis.annotations.*;

public interface OfficeDao extends BaseDao<Office> {
    @Select("select * from office")
    Office[] selectAll();

    @Select("select * from office where id=#{id}")
    Office select(@Param("id") int id);

    @Delete("delete from office where id=#{id}")
    void delete(@Param("id") int id);

    @Update("update office set ${key} = #{value} where id=${id}")
    void update(@Param("id") int id, @Param("key") String key, @Param("value") String value);

    @Insert("insert into office (name,personId) values(#{name},#{personId})")
    void create(Office object);
}