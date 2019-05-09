package cn.niit.springbootsendcode.controller;

import cn.niit.springbootsendcode.util.SmsDemo;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;
@Controller
public class TestController {
    @Autowired
    @Qualifier("redisTemplate")//实例化
    private RedisTemplate<Object, Object> rts;

    @RequestMapping(value = "/")
    public String register()
    {
        System.out.println("sign_html");
        return "sign_in.html";
    }


    @RequestMapping("/getCode")
    @ResponseBody
    public String getCode(String username)throws Exception{
        //rts.opsForValue().set("17730223870",123456);
        System.out.println("phone=" + username);
        SmsDemo smsDemo = new SmsDemo();
        smsDemo.setNewcode();
        String code = Integer.toString(smsDemo.getNewcode());
        SendSmsResponse sendSms = smsDemo.sendSms(username, code);//填写你需要测试的手机号码
        //将手机号和验证码存入redis,生存时间为5分钟
        rts.opsForValue().set(username,code,1, TimeUnit.MINUTES);
        System.out.println("短信接口返回的数据----------------");
        System.out.println("Code=" + sendSms.getCode());
        System.out.println("Message=" + sendSms.getMessage());
        System.out.println("RequestId=" + sendSms.getRequestId());
        System.out.println("BizId=" + sendSms.getBizId());
        return sendSms.getCode();
    }


    /**
     * 检测短信验证码是否相同  登陆
     */

    @RequestMapping("/plogin")
    @ResponseBody
    public Object plogin(String username, String pcode, HttpSession session) throws Exception {
        System.out.println("username=" + username + ";pcode=" + pcode);
        try{
            Object code=rts.opsForValue().get(username);
            if (code.equals(pcode)) {
             return  "成功";
            } else {
                System.out.println("验证码错误");
                return false;
            }
        }catch (Exception e){
            System.out.println("验证码失效");
            e.printStackTrace();
        }
        return false;
    }
}
