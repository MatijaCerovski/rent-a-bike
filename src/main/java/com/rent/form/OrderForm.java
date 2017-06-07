package com.rent.form;

import com.rent.persistence.model.Bike;
import com.rent.persistence.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Toni on 07-Jun-17.
 */

@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderForm {

    @NotNull
    @NotEmpty
    @Size(max = 12)
    private String startDate;

    @NotNull
    @NotEmpty
    @Size(max = 12)
    private String endDate;

    @NotNull
    private int bikeId;

}
