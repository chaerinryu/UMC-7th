package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.MissionChallengedValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionChallengedValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MissionChallenged {
    String message() default "해당 미션은 이미 도전 중입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String memberIdField();
    String missionIdField();
}
