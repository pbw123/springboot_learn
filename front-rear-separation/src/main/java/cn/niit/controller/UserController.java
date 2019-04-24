package cn.niit.controller;

import cn.niit.entity.User;
import cn.niit.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * Created by 公子白 on 2019/4/23.
 */
@RestController
@RequestMapping(value = "/api",produces = APPLICATION_JSON_VALUE)
@Api(description = "用户管理")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "用户列表",notes = "查寻所有已注册过的用户信息")
    @RequestMapping(value = "getAll",method = RequestMethod.GET)
    public List<User> getAll()
    {
        return userMapper.findAll();
    }
}
