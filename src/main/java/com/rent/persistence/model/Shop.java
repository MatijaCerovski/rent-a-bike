package com.rent.persistence.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Matija on 25.5.2017..
 */
@Entity
public class Shop {
    private Long shopId;
    private String name;
    private List<Bike> bikes;

    @Id
    @GeneratedValue
    @Column(name = "shop_id")
    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "shop")
    public List<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(List<Bike> bikes) {
        this.bikes = bikes;
    }
}
