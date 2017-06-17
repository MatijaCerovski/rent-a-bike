package com.rent.validation;

import com.rent.form.BikeForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

/**
 * Created by dotocan on 9.6.2017..
 */

@Component
public class BikeFormValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return BikeForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "maker", "empty");
        ValidationUtils.rejectIfEmpty(errors, "model", "empty");
        ValidationUtils.rejectIfEmpty(errors, "price", "empty");

        BikeForm bikeForm = (BikeForm) o;

        if (bikeForm.getPrice() != null) {
            if (bikeForm.getPrice().compareTo(BigDecimal.valueOf(10)) == -1) {
                errors.rejectValue("price", "too.low.value");
            } else if (bikeForm.getPrice().compareTo(BigDecimal.valueOf(200)) == 1) {
                errors.rejectValue("price", "too.high.value");
            }
        }

    }
}
