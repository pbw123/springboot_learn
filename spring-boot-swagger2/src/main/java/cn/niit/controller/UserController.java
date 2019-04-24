package cn.niit.controller;

import cn.niit.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * Created by 公子白 on 2019/4/24.
 */
@RestController
@Api(description = "用户管理")
@RequestMapping(value = "/hello",produces = APPLICATION_JSON_VALUE)
public class UserController {

    List<User>lists=new ArrayList<>();

    @GetMapping(value ="getAllUser" )
    @ApiOperation(value = "用户列表",notes = "查询所有已注册过的用户详细信息")
    public List<User> getAllUser()
    {
    lists.add(new User("wen","999"));
    lists.add(new User("2","qian","666"));
    return lists;
    }

    @PostMapping(value = "addUser")
    public User addUser(User user)
    {
        return user;
    }

    @GetMapping(value = "getUserById/{id}")
    public User getUserById(@ApiParam(value = "用户ID")@PathVariable(value = "id")String id)
    {
        return new User(id,"步惊云","passwordjava");
    }
}
