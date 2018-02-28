package com.tsystems.train.validation.constraint;

import com.tsystems.train.validation.validator.ScheduleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ScheduleValidator.class)
public @interface ScheduleConstraint {
    String message() default "{com.tsystems.train.stationservice.validation.constraint.ScheduleConstraint.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
