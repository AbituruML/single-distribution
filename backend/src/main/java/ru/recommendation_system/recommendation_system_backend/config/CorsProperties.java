package ru.recommendation_system.recommendation_system_backend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "cors")
public record CorsProperties (
    List<String> allowedOrigins,
    List<String> allowedMethods,
    List<String> allowedHeaders,
    List<String> exposedHeaders,
    boolean allowCredentials
){
}
