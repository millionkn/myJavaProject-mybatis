package com.mytest.dao;

import com.mytest.Entries.Supplier;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SupplierDao extends BaseDao<Supplier> {
    @Select("select * from supplier")
    Supplier[] selectAll();

    @Select("select * from supplier where id=#{id}")
    Supplier select(int id);

    @Delete("delete from supplier where id=#{id}")
    void delete(int id);

    @Update("update supplier set ${key} = #{value} where id=${id}")
    void update(int id, @Param("key") String key, @Param("value") String value);

    @Insert("insert into supplier (name,businessLicense,medicalDeviceBusinessLicense) values(#{name},#{businessLicense},#{medicalDeviceBusinessLicense})")
    void create(Supplier supplier);
}