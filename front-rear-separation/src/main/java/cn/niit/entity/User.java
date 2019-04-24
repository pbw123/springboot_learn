package cn.niit.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 55)
    private String name;
    private String avatarURL;
}