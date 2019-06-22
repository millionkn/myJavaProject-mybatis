package com.mytest.dao;

import com.mytest.Entries.Role;
import org.apache.ibatis.annotations.*;

@Mapper
public interface RoleDao extends BaseDao<Role> {
    @Select("select * from role")
    Role[] selectAll();

    @Select("select * from role where id=#{id}")
    Role select(int id);

    @Delete("delete from role where id=#{id}")
    void delete(int id);

    @Update("update role set ${key} = #{value} where id=${id}")
    void update(int id, @Param("key") String key, @Param("value") String value);
}