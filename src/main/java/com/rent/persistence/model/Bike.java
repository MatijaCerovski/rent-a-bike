package com.rent.persistence.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Matija on 25.5.2017..
 */
@Entity
@Data
public class Bike {

    @Id
    @GeneratedValue
    @Column(name = "bike_id")
    private int bikeId;

    @Basic
    @Column(name = "maker")
    private String maker;

    @Basic
    @Column(name = "model")
    private String model;

    @Basic
    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @OneToMany(mappedBy = "bike")
    @Cascade(CascadeType.DELETE)
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;
}
