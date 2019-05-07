package cn.niit.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by 公子白 on 2019/5/5.
 */
@Entity
@Data
public class SysUser implements Serializable {

    @Id
    @GeneratedValue
    private Integer userId;
    @NotEmpty
    private String userName;
    @NotEmpty
    private String passWord;

    //多对多关系
    @ManyToMany(fetch = FetchType.EAGER)
    //急加载，加载一个实体时，定义急加载的属性会立即从数据库中加载
    //FetchType.LAZY：懒加载，加载一个实体时，定义懒加载的属性不会马上从数据库中加载
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<SysRole> roleList;// 一个用户具有多个角色

}