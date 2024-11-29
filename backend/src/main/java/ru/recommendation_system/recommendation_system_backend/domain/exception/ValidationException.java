package ru.recommendation_system.recommendation_system_backend.domain.exception;

import jakarta.validation.ConstraintViolation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.recommendation_system.recommendation_system_backend.model.DtoRecommendationPostRequest;

import java.util.Set;

@Getter
@AllArgsConstructor
public class ValidationException extends RecommendationSystemCommonException {
    private Set<ConstraintViolation<DtoRecommendationPostRequest>> violations;
}
