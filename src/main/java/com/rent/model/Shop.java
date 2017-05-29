package com.rent.model;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        if (shopId != shop.shopId) return false;
        if (name != null ? !name.equals(shop.name) : shop.name != null) return false;

        return true;
    }

//    @Override
//    public int hashCode() {
//        int result = shopId;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        return result;
//    }

    @OneToMany(mappedBy = "shop")
    public List<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(List<Bike> bikes) {
        this.bikes = bikes;
    }
}
