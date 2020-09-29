package com.esteel.user.service.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author liujie
 * @version 1.0.0
 * @ClassName PassowrdValidator.java
 * @Description TODO
 * @createTime 2020年5月16日 18:10
 */
public class PasswordValidator implements ConstraintValidator<PasswordVerify,Object> {

    public static final String REG_PHONE = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";

    /**
     * Implements the validation logic.
     * The state of {@code value} must not be altered.
     * <p>
     * This method can be accessed concurrently, thread-safety must be ensured
     * by the implementation.
     *
     * @param value   object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code false} if {@code value} does not pass the constraint
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return Pattern.matches(REG_PHONE, (String)value);
    }
}
