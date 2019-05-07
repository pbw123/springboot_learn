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
public class SysMenu implements Serializable {

    @Id
    @GeneratedValue
    private Integer menuId;
    private String menuName;

    @ManyToMany
    @JoinTable(name = "SysRoleMenu", joinColumns = {@JoinColumn(name = "menuId")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<SysRole> roleList;
}
