package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 潘炳稳 on 2019/3/29.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping(value = "save")
    public String save(int id,String userName)
    {
        User user=new User(id,userName);
        userService.set(id+"",user);
         return "保存成功";
    }
    @GetMapping(value = "getValue")
    public Object getValue(int id)
    {
       return userService.get(id+"");
    }
}
