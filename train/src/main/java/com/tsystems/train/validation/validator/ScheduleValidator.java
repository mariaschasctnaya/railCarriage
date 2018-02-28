package com.tsystems.train.validation.validator;

import com.tsystems.train.exception.ScheduleNotValidException;
import com.tsystems.train.exception.StationsScheduleHasWrongOrder;
import com.tsystems.train.facade.data.ScheduleData;
import com.tsystems.train.validation.constraint.ScheduleConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;
import java.util.Set;

public class ScheduleValidator implements ConstraintValidator<ScheduleConstraint, Map<String, ScheduleData>> {
    @Override
    public void initialize(ScheduleConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(Map<String, ScheduleData> value, ConstraintValidatorContext context) {
        Set<Map.Entry<String, ScheduleData>> entries = value.entrySet();
        Map.Entry<String, ScheduleData> prevSchedule = null;
        for (Map.Entry<String, ScheduleData> entry : entries) {
            if(prevSchedule == null) {
                prevSchedule = entry;
            }
            else {
                if(prevSchedule.getValue().getDeparture().isAfter(entry.getValue().getArrive()))
                    throw new StationsScheduleHasWrongOrder(prevSchedule.getKey(), entry.getKey());

            }
            if(entry.getValue().getDeparture().isBefore(entry.getValue().getArrive()))
                throw new ScheduleNotValidException(entry.getKey());
        }
        return true;
    }
}
