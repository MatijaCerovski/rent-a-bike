package com.rent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.rent.persistence.model.OrderStatus;
import java.time.LocalDate;

/**
 * Created by Toni on 19-Jun-17.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private int orderId;
    private String startDate;
    private String endDate;
    private int userId;
    private int bikeId;
    private OrderStatus status;

}
