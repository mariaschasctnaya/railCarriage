package com.tsystems.train.validation.validator;


import com.tsystems.train.exception.FutureTimeException;
import com.tsystems.train.validation.constraint.Past;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class PastDateValidator implements ConstraintValidator<Past, LocalDate> {
    @Override
    public void initialize(Past constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if(value.isAfter(LocalDate.now()))
            throw new FutureTimeException();
        return true;
    }
}
