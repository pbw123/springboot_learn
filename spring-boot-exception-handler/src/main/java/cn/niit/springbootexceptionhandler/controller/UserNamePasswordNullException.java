package cn.niit.springbootexceptionhandler.controller;

public class UserNamePasswordNullException extends Exception {
    public UserNamePasswordNullException() {
        super("请输入用户名和密码");
    }
}
