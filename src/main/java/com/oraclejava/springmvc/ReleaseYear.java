package com.oraclejava.springmvc;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ReleaseYearValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReleaseYear {

    String message() default "개봉년도는  1895~현재년도(+3)입니다";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
