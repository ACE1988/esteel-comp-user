package com.esteel.user.service.utils;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liujie
 * @version 1.0.0
 * @ClassName PasswordVerify.java
 * @Description TODO
 * @createTime 2020年5月16日 18:09
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordVerify {
	
	String message() default "Incorrect password format. The password must consist of letters and numbers, contain between 6 and 15 characters leaving no space";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
