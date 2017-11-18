package com.sibftie.validator;

import com.sibftie.service.AkunService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by solo on 25/05/2017.
 */
public class EmailExistValidator implements ConstraintValidator<EmailExist, String>
{
    @Autowired
    AkunService a;
    @Override
    public void initialize(EmailExist constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        boolean isTrue = false;
        try {
            if(a.getAkunByEmail(email) == null)
            {
                isTrue = true;
            }
        }catch (NullPointerException n)
        {
            isTrue = true;
        }
        return isTrue;
    }
}
