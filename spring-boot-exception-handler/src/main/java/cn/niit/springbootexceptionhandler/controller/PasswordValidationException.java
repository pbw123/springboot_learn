package cn.niit.springbootexceptionhandler.controller;

public class PasswordValidationException extends Exception {
    public PasswordValidationException() {
        super("密码只能由6到16位的数字或字母组成");
    }
}
