package ru.recommendation_system.recommendation_system_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class RecommendationSystemBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecommendationSystemBackendApplication.class, args);
    }

}
