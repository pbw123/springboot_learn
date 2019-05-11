package cn.niit.springbootexceptionhandler.controller;

public class PasswoldNullException extends Exception {
    public PasswoldNullException() {
        super("密码不能为空");
    }
}
