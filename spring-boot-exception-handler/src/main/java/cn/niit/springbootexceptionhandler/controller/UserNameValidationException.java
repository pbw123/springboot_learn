package cn.niit.springbootexceptionhandler.controller;

public class UserNameValidationException extends Exception{
    public UserNameValidationException() {
        super("请输入6到16位的数字或字母组合");
    }
}
