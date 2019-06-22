package com.mytest.dao;

import com.mytest.Entries.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao extends BaseDao<User> {
    @Select("select * from user")
    User[] selectAll();

    @Select("select * from user where id=#{id}")
    User select(@Param("id") int id);

    @Delete("delete from user where id=#{id}")
    void delete(@Param("id") int id);

    @Update("update user set ${key} = #{value} where id=${id}")
    void update(@Param("id") int id, @Param("key") String key, @Param("value") String value);
}