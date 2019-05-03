package cn.niit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 公子白 on 2019/4/24.
 */
@RestController
public class TestController {
    @GetMapping(value = "test")
    public String test()
    {
        return "hello test";
    }
}
