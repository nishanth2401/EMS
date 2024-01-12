package com.excelr.mainpackage.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    private static final String PHONE_NUMBER_PATTERN = "^[0-9]{10}$"; // Example: 1234567890

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        return phoneNumber == null || Pattern.matches(PHONE_NUMBER_PATTERN, phoneNumber);
    }
}