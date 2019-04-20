package cn.niit.controller;

import cn.niit.util.MsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 潘炳稳 on 2019/4/14.
 */
@Controller
public class UserController {
    @Autowired
    private HttpServletRequest request; //自动注入request

@GetMapping(value = "/")
public String sign(Model model)
{
    String code= MsUtil.send("你接收验证码的手机号");
//    String verifyCode = verifyCodeGenerator.getVerifyCode();
    model.addAttribute("code","验证码是"+code);

    request.getSession().setAttribute("code",code);
//    attr.addFlashAttribute("code",code);
    return "sign_in.html";
}
//匹配输入的验证码和发送的验证码是否一致
    @PostMapping(value = "matchCode")
    public String matchCode(@RequestParam String yourCode,Model model) {
        String code =(String) request.getSession().getAttribute("code");
        System.out.println("code===="+code);
        if (yourCode.equals(code)){
            System.out.println("成功");
           model.addAttribute("result","成功");
        }else {
            System.out.println("失败");
            model.addAttribute("result","失败");
        }
        return "test";
    }
}
