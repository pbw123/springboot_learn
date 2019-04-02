package cn.niit.controller;//package cn.niit.controller;

import cn.niit.dao.UserMapper;
import cn.niit.entity.User;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 潘炳稳 on 2019/4/2.
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "getUserList")
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    //条件查询
    @GetMapping(value = "getUserListByName")
    public List<User> getUserListByName(String userName) {
        Map map = new HashMap();
        map.put("user_name", userName);
        return userMapper.selectByMap(map);
    }

    //根据Id查询User
    @GetMapping("getUserById")
    public User getUserById(Integer userId) {
        return userMapper.selectById(userId);
    }

    //http://localhost:8888/getUserListByPage?pageNumber=1&pageSize=2
    //条件分页查询
    @GetMapping(value = "getUserListByPage")
    public List<User> getUserListByPage(Integer pageNum, Integer pageSize) {
        Page<User> page = new Page<>(pageNum, pageSize);
        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("user_name", "xiaoli");
        return userMapper.selectPage(page, entityWrapper);
    }

    //保存用户
    @GetMapping(value = "saveUser")
    public String saveUser(String userName, String userPassword) {
        User user = new User(userName, userPassword);
        Integer insert = userMapper.insert(user);
        if (insert > 0) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    //修改用户
    @GetMapping(value = "updateUser")
    public String updateUser(Integer id,String userName,String userPassword)
    {
        User user = new User(id, userName, userPassword);
        Integer index = userMapper.updateById(user);
        if (index>0)
        {
            return "修改成功";
        }else {
            return "修改失败";
        }
    }
}
