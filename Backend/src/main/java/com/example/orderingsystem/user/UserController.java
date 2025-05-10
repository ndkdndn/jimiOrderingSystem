package com.example.orderingsystem.user;

import com.example.orderingsystem.result.Result;
import com.example.orderingsystem.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("selectById")
    public Result selectByName(Integer id){
        User user = userService.selectById(id);
        if(user==null) return Result.error("未找到指定用户");
        return Result.success(user);
    }

    @DeleteMapping("deleteById")
    public Result deleteById(Integer id){
        Boolean isDeleted = userService.deleteById(id);
        if(isDeleted==false) return Result.error("未找到指定用户");
        return Result.success();
    }

    @PostMapping("selectByNameAndPassword")
    public Result selectByNameAndPassword(String name,String password){
        User user = userService.selectByNameAndPassword(name,password);
        if(user==null) return Result.error("未找到指定用户");
        return Result.success(user);
    }
}
