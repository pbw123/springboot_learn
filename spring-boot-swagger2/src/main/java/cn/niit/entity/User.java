package cn.niit.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by 公子白 on 2019/4/24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @ApiModelProperty(value = "用户ID")
    private String id;
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(hidden = true)
    private String password;
}
