package com.umc.mission7.validation.validator;

import com.umc.mission7.apiPayload.code.status.ErrorStatus;
import com.umc.mission7.domain.Store;
import com.umc.mission7.service.storeService.StoreQueryService;
import com.umc.mission7.validation.annotation.ExistStore;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStore, Long> {
    private final StoreQueryService storeQueryService;

    @Override
    public void initialize(ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Optional<Store> target = storeQueryService.findStore(value);

        if (target.isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
