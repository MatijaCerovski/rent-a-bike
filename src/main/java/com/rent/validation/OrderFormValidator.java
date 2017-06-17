package com.rent.validation;

import com.rent.form.OrderForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by dotocan on 16.6.2017..
 */

@Component
public class OrderFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return OrderForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "startDate", "empty");
        ValidationUtils.rejectIfEmpty(errors, "endDate", "empty");

        OrderForm orderForm = (OrderForm) o;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate startDate = LocalDate.parse(orderForm.getStartDate(), formatter);
        LocalDate endDate = LocalDate.parse(orderForm.getEndDate(), formatter);

        if (startDate.isBefore(LocalDate.now())) {
            errors.rejectValue("startDate", "before.today");
        }

        if (endDate.isBefore(startDate)) {
            errors.rejectValue("endDate", "before.start.date");
        }
    }
}
