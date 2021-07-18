package br.com.zup.orange.projetozupspring1.valiacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = ValidaNascMenor18Validator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidaNascMenor18 {

    String message() default "Idade deve ser maior de 18 anos";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    //String value() default "";

}
