package cn.niit.springbootexceptionhandler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResult {
    private int code;
    private String msg;
}
