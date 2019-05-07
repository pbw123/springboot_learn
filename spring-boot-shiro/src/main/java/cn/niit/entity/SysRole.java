package cn.niit.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by 公子白 on 2019/5/5.
 */
@Entity
@Data
public class SysRole implements Serializable {

    @Id
    @GeneratedValue
    private Integer roleId;

    private String roleName;

    //多对多关系
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysRoleMenu", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "menuId")})
    private List<SysMenu> menuList;

    //多对多关系
    @ManyToMany
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "userId")})
    private List<SysUser> userList;// 一个角色对应多个用户
}