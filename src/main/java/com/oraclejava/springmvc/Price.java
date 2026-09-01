package com.oraclejava.springmvc;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PriceValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Price {

    String message() default "영화 가격은 1이상 50,000 이하입니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
