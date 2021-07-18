package br.com.zup.orange.projetozupspring1.valiacao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class ValidaNascMenor18Validator implements ConstraintValidator<ValidaNascMenor18, LocalDate> {

    @Override
    public void initialize(ValidaNascMenor18 constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext constraintValidatorContext) {

        if (value != null) {
            int idade = Period.between(value, LocalDate.now()).getYears();

            return idade >= 18;

        } else {
            return true;
        }

    }
}
