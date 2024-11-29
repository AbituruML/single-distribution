package ru.recommendation_system.recommendation_system_backend.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.recommendation_system.recommendation_system_backend.model.DtoDirectionsStudyInner;
import ru.recommendation_system.recommendation_system_backend.model.DtoRecommendationPostRequest;
import ru.recommendation_system.recommendation_system_backend.service.RecommendationDirectionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationDirectionallyApiDelegateImpl implements RecommendationDirectionallyApiDelegate {
    private final RecommendationDirectionService recommendationDirectionService;

    @Override
    public ResponseEntity<List<DtoDirectionsStudyInner>> directionStudyGet() {
        return ResponseEntity.ok(recommendationDirectionService.getAllStudyDirections());
    }

    @Override
    public ResponseEntity<List<DtoDirectionsStudyInner>> recommendationPost(DtoRecommendationPostRequest dtoRecommendationPostRequest) {
        return ResponseEntity.ok(recommendationDirectionService.getRecommendationDirection(dtoRecommendationPostRequest));
    }

}
