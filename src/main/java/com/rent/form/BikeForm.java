package com.rent.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Created by dotocan on 7.6.2017..
 */

@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BikeForm {

    @NotNull
    @NotEmpty
    @Size(max = 40)
    private String maker;

    @NotNull
    @NotEmpty
    @Size(max = 40)
    private String model;

    @NotNull
    @DecimalMax("200.00")
    private BigDecimal price;

//    @NotNull
//    @NotEmpty
//    @Size(max = 10)
//    private int numInStock;
}
