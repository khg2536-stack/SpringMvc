package com.oraclejava.springmvc;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PriceValidator
    implements ConstraintValidator<Price, Integer> {
    @Override
    public void initialize(Price constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer Price, ConstraintValidatorContext constraintValidatorContext) {
        if(1 <= Price && Price <= 50000){
            return true;
        }
        return false;
    }
}
