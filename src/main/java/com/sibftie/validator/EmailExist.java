package com.sibftie.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailExist
{
    String message() default "Email telah terdaftar";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
