package com.springboot.amallproduct.mapper;

import com.springboot.amallproduct.bean.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Insert("insert into products(pname,type,price) values (#{pname},#{type},#{price}) ")
     Integer add(Product product);

    @Delete("delete from products where pid=#{arg1}")
     Integer delete(Integer id);


    @Update("update products set pname=#{pname},type=#{type},price=#{price} where pid =#{id}")
     Integer update(Product product);

    @Select("select * from products where pid=#{arg2}")
    @Results(id="userResults", value={
            @Result(property="createTime", column="create_time"),
    })
     Product getById(Integer id);

    @Select("select * from products order by pid desc")
     List<Product> queryLists();

}
