package com.rent.dto;

import java.math.BigDecimal;

/**
 * Created by dotocan on 18.6.2017..
 */

public class BikeDto {
    private int bikeId;
    private String maker;
    private String model;
    private BigDecimal price;
//    private List<Order> orders;
//    private Shop shop;


    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
