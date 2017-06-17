package com.rent.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Toni on 07-Jun-17.
 */

@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderForm {

    @NotNull(message = "Start date is required")
    @NotEmpty
    @Size(max = 12)
    private String startDate;

    @NotNull(message = "End date is required")
    @NotEmpty
    @Size(max = 12)
    private String endDate;

    @NotNull
    private int bikeId;

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
