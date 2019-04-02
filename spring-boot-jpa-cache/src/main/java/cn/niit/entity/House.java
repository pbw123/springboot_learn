package cn.niit.entity;

import javax.persistence.*;

/**
 * Created by 潘炳稳 on 2019/4/2.
 */
@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 10)
    private String houseName;
    private String houseSize;

    public House(Integer id,String houseName, String houseSize) {
        this.houseName = houseName;
        this.houseSize = houseSize;
        this.id=id;
    }

    public House() {
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseSize() {
        return houseSize;
    }

    public void setHouseSize(String houseSize) {
        this.houseSize = houseSize;
    }
}
