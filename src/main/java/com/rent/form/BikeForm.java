package com.rent.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
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

//    @NotNull(message = "Maker field is required")
//    @NotEmpty(message = "Maker field is required")
//    @Size(max = 20, message = "Max number of characters is 20")
    private String maker;

//    @NotNull(message = "Model field is required")
//    @NotEmpty(message = "Model field is required")
//    @Size(max = 20, message = "Max number of characters is 20")
    private String model;

//    @NotNull(message = "Price field is required")
//    @DecimalMax(value = "200.00", message = "Highest price value can be 200")
//    @DecimalMin(value = "10.00", message = "Lowest price value can be 10")
    private BigDecimal price;

//    @NotNull
//    @NotEmpty
//    @Size(max = 10)
//    private int numInStock;


    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
