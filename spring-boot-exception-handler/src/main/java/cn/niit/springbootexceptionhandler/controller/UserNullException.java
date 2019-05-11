package cn.niit.springbootexceptionhandler.controller;

public class UserNullException extends Exception{


    public UserNullException() {
        super("用户名不能为空");
    }
}
