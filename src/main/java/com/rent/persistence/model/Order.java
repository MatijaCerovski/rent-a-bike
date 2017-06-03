package com.rent.persistence.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Matija on 25.5.2017..
 */
@Entity
public class Order {
    private int orderId;
    private Date startDate;
    private Date endDate;
    private Users user;
    private Bike bike;
    private OrderStatus status;

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    public OrderStatus getOrderStatus(){return status;}

    public void setOrderStatus(OrderStatus status){this.status = status;};

    @ManyToOne
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @ManyToOne
    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }
}
