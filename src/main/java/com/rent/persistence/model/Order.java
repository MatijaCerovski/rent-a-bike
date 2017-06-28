package com.rent.persistence.model;

import com.rent.converter.LocalDateAttributeConverter;

import javax.persistence.*;
import java.time.LocalDate;


/**
 * Created by Matija on 25.5.2017..
 */
@Entity
@Table(name = "orders")
public class Order {
    private int orderId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Users user;
    private Bike bike;
    private OrderStatus status;

    public Order()
    {

    }

    public Order(int OrderId, LocalDate StartDate, LocalDate EndDate)
    {
        this.orderId = OrderId;
        this.startDate = StartDate;
        this.endDate = EndDate;
    }

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }



    @Column(name = "start_date")
    @Convert(converter = LocalDateAttributeConverter.class)
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }



    @Column(name = "end_date")
    @Convert(converter = LocalDateAttributeConverter.class)
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    public OrderStatus getOrderStatus(){return status;}

    public void setOrderStatus(OrderStatus status){this.status = status;};

    @ManyToOne
    @JoinColumn(name = "user_id")
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "bike_id")
    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }
}
