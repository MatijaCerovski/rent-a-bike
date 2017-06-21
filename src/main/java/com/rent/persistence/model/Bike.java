package com.rent.persistence.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Matija on 25.5.2017..
 */
@Entity
public class Bike {
    private int bikeId;
    private String maker;
    private String model;
    private BigDecimal price;
    private List<Order> orders;
    private Shop shop;

    @Id
    @GeneratedValue
    @Column(name = "bike_id")
    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    @Basic
    @Column(name = "maker")
    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "price", precision = 10, scale = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @OneToMany(mappedBy = "bike")
    @Cascade(CascadeType.DELETE)
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @ManyToOne
    @JoinColumn(name = "shop_id")
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
