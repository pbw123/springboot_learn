package cn.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 潘炳稳 on 2019/4/3.
 */
@Controller
public class ThymeleafController {
    @RequestMapping(value = "/")
    public String thymeleafTest(ModelMap modelMap) {
        modelMap.addAttribute("msg", "你好公子潘");
        modelMap.addAttribute("tag", "http://localhost:8080/gtvg/order/details");
        int[] s=new int[]{9,9,34};
        modelMap.addAttribute("one","s");
        List<Map<String,Object>>list=new ArrayList<>();
        Map<String,Object>m=new HashMap<>();
        m.put("name","pan");
        list.add(m);
        m=new HashMap<>();
        m.put("name","chen");
        list.add(m);
        m=new HashMap<>();
        m.put("name","chenyiqiao");
        list.add(m);
        m=new HashMap<>();
        m.put("name","kai");
        list.add(m);

        modelMap.addAttribute("list",list);
        return "thymeleaf";
    }

    @RequestMapping(value = "/tag")
    public String tag()
    {
        return "test";
    }
}
