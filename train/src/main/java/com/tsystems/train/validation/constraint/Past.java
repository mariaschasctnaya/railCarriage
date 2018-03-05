package com.tsystems.train.validation.constraint;

import com.tsystems.train.validation.validator.PastDateValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PastDateValidator.class)
public @interface Past {
    String message() default "{com.tsystems.sbb.ticketservice.validation.constraint.Past.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
