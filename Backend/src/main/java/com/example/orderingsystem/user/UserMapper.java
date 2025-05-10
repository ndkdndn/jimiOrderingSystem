package com.example.orderingsystem.user;

import com.example.orderingsystem.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from users where id = #{id}")
    public User selectById(int id);

    @Select("SELECT * FROM users WHERE username = #{name} AND password = #{password}")
    User selectByNameAndPassword(@Param("name") String name, @Param("password") String password);

    @Delete("delete from users where id = #{id}")
    public int deleteById(int id);


}
