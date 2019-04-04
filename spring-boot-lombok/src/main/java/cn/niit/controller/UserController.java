package cn.niit.controller;

import cn.niit.entity.User;
import cn.niit.entity.UserHaveLombok;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 潘炳稳 on 2019/4/4.
 */
@RestController
public class UserController {

    @GetMapping(value = "/")
    public List<User> UserTest()
    {
        User user=new User();
        user.setId(2);
        user.setName("pan");
        List<User>list=new ArrayList<>();
        list.add(user);
        User user1=new User(3,"chen");
        list.add(user1);
        return list;
    }

    @RequestMapping(value = "userHaveLombok")
    public List<UserHaveLombok> haveLomboks()
    {
        List<UserHaveLombok>lists=new ArrayList<>();
        UserHaveLombok userHaveLombok=new UserHaveLombok();
        userHaveLombok.setAge(9);
        userHaveLombok.setName("panbingwen");
        lists.add(userHaveLombok);
        UserHaveLombok userHaveLombok1=new UserHaveLombok("chen",8);
        lists.add(userHaveLombok1);
        return lists;
    }
}
