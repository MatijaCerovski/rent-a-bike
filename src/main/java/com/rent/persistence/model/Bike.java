package com.rent.persistence.model;

import javax.persistence.*;
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
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bike bike = (Bike) o;

        if (bikeId != bike.bikeId) return false;
        if (maker != null ? !maker.equals(bike.maker) : bike.maker != null) return false;
        if (model != null ? !model.equals(bike.model) : bike.model != null) return false;
        if (price != null ? !price.equals(bike.price) : bike.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bikeId;
        result = 31 * result + (maker != null ? maker.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "bike")
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @ManyToOne
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
