package ru.recommendation_system.recommendation_system_backend.entity;

import lombok.Builder;

@Builder
public record StudyDirectionEntity(
        String id,
        String name,
        String code
) {
}
