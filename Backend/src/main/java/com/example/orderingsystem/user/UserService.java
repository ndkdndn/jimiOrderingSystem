package com.example.orderingsystem.user;

import com.example.orderingsystem.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserService {
    public User selectById(Integer id);

    public Boolean deleteById(Integer id);

    public User selectByNameAndPassword(String name,String password);
}
