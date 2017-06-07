package com.rent.validation;

/**
 * Created by Matija on 5.6.2017..
 */


import com.rent.form.UserRegistrationForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserRegistrationForm user = (UserRegistrationForm) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}