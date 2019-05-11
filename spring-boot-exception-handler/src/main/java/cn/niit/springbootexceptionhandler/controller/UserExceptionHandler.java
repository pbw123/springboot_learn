package cn.niit.springbootexceptionhandler.controller;

import cn.niit.springbootexceptionhandler.entity.UserResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = UserNullException.class)
    public  @ResponseBody UserResult userNull(HttpServletRequest request,Exception ex)
    {
        UserResult userResult=new UserResult();
        userResult.setCode(9);
        userResult.setMsg(ex.getMessage());
        return userResult;
    }
    @ExceptionHandler(value = PasswoldNullException.class)
    public   UserResult passwordNull(HttpServletRequest request,Exception ex)
    {
        UserResult userResult=new UserResult();
        userResult.setCode(10);
        userResult.setMsg(ex.getMessage());
        return userResult;
    }
    @ExceptionHandler(value = UserNamePasswordNullException.class)
    public  @ResponseBody UserResult namePassNull(HttpServletRequest request,Exception ex)
    {
        UserResult userResult=new UserResult();
        userResult.setCode(11);
        userResult.setMsg(ex.getMessage());
        return userResult;
    }
    @ExceptionHandler(value = UserNameValidationException.class)
    public  @ResponseBody UserResult UserNameValidation(HttpServletRequest request,Exception ex)
    {
        UserResult userResult=new UserResult();
        userResult.setCode(12);
        userResult.setMsg(ex.getMessage());
        return userResult;
    }
    @ExceptionHandler(value = PasswordValidationException.class)
    public  @ResponseBody UserResult  PasswordValidation(HttpServletRequest request,Exception ex)
    {
        UserResult userResult=new UserResult();
        userResult.setCode(13);
        userResult.setMsg(ex.getMessage());
        return userResult;
    }
}
