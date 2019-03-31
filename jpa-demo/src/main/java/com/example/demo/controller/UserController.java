package com.example.demo.controller;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 潘炳稳 on 2019/3/28.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value ="findAllUser")
    public List findAll()
    {
        return userRepository.findAll();
    }

    @GetMapping(value = "getOne")
    public Users getOne(Integer id)
    {
//        Users users= userRepository.findOne(id);
//        return users;
        return userRepository.findOne(id);
    }
    @GetMapping(value = "delUserById")
    public String delUserById(int id)
    {
          userRepository.delete(id);
          return "delete success";
    }
    @GetMapping(value = "save")
    public String save(String userName,String password)
    {
//        userRepository.save(userName,password);
        Users users=new Users(userName,password);
        userRepository.save(users);
        return "save success";
    }

}
