package com.example.orderingsystem.user.Impl;

import com.example.orderingsystem.user.UserMapper;
import com.example.orderingsystem.user.UserService;
import com.example.orderingsystem.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public Boolean deleteById(Integer id) {
        return userMapper.deleteById(id)>0;
    }

    @Override
    public User selectByNameAndPassword(String name, String password) {
        // 为空？
        System.out.println(userMapper.selectByNameAndPassword(name,password).getPassword());
        return userMapper.selectByNameAndPassword(name,password);
    }
}
