package ru.recommendation_system.recommendation_system_backend.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/health")
    public ResponseEntity<?> health() {
        return ResponseEntity.ok().build();
    }
}
