package com.oraclejava.springmvc;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;

public class ReleaseYearValidator
    implements ConstraintValidator<ReleaseYear, Integer>{

    @Override
    public void initialize(ReleaseYear constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer year, ConstraintValidatorContext constraintValidatorContext) {
        if(year == null){
            return true;
        }
        int currentYear = LocalDateTime.now().getYear();
        int firstFilm = 1895;

        if(year >= firstFilm && year <= currentYear + 3);

        return false;
    }
}
