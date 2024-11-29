package ru.recommendation_system.recommendation_system_backend.domain.exception;

public class ServiceUnavailableException extends RecommendationSystemCommonException {
    public ServiceUnavailableException() {
        super("Ремендательная система в данный момент не может обработать данныйх запрос. Пожалуйста повторите попытку позднее.");
    }
}
