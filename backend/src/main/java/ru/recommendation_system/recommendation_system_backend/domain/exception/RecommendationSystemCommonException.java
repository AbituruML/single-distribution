package ru.recommendation_system.recommendation_system_backend.domain.exception;

public abstract class RecommendationSystemCommonException extends RuntimeException {
    public RecommendationSystemCommonException(String message) {
        super(message);
    }

    public RecommendationSystemCommonException() {}
}
