package cn.niit.springbootexceptionhandler.controller;

import cn.niit.springbootexceptionhandler.entity.User;
import cn.niit.springbootexceptionhandler.entity.UserResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.regex.Pattern;

@RestControllerAdvice
@RequestMapping(value = "user/api")
public class SignInController {

    @PostMapping(value = "/sign_in")
    public UserResult signIn(@RequestBody User user) throws Exception {
        if (user.getUserName()==null&&user.getPasswold()==null)
        {
            throw new UserNamePasswordNullException();
        }else if (user.getUserName()==null)
        {
            throw new UserNullException();
        }else if (user.getPasswold()==null)
        {
                throw new  PasswoldNullException();
        }else {
            if (userNameRegex(user.getUserName())==false){
              throw new UserNameValidationException();
            }else if (passRegex(user.getPasswold())==false){
                throw new PasswordValidationException();
            }
        }
        return new UserResult(0,"登录成功");
    }
    /**
     * 正则表达式：验证规则
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";
    /**
     * 手机号
     */
    String PHONE_NUMBER_REG = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";

    public boolean userNameRegex(String userName)
    {
        return Pattern.matches(REGEX_PASSWORD, userName);
    }
    public boolean passRegex(String password)
    {
        return Pattern.matches(REGEX_PASSWORD, password);
    }

}
