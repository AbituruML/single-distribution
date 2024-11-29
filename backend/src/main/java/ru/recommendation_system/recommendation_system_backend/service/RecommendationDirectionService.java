package ru.recommendation_system.recommendation_system_backend.service;

import ai.onnxruntime.OnnxMap;
import ai.onnxruntime.OnnxTensor;
import ai.onnxruntime.OrtEnvironment;
import ai.onnxruntime.OrtException;
import ai.onnxruntime.OrtSession;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import ru.recommendation_system.recommendation_system_backend.domain.exception.ServiceUnavailableException;
import ru.recommendation_system.recommendation_system_backend.domain.mapper.ONNXMapper;
import ru.recommendation_system.recommendation_system_backend.model.DtoDirectionsStudyInner;
import ru.recommendation_system.recommendation_system_backend.model.DtoRecommendationPostRequest;
import ru.recommendation_system.recommendation_system_backend.repository.RecommendationRepository;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.util.CollectionUtils.firstElement;

@Service
@RequiredArgsConstructor
public class RecommendationDirectionService {
    private final RecommendationRepository recommendationRepository;
    private final ONNXMapper onnxMapper;
    private final ResourceLoader resourceLoader;
    private final String PATH_ONNX_MODEL = "classpath:static/ml/model.onnx";

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public List<DtoDirectionsStudyInner> getAllStudyDirections() {
        return recommendationRepository.getAllStudyDirections().entrySet().stream()
                .map(direction -> DtoDirectionsStudyInner.builder()
                        .name(direction.getKey())
                        .code(direction.getValue())
                        .build()).toList();
    }

    private DtoDirectionsStudyInner getDirection(String name) {
        return DtoDirectionsStudyInner.builder()
                .name(name)
                .code(recommendationRepository.getStudyDirectionCode(name))
                .build();
    }

    public List<DtoDirectionsStudyInner> getRecommendationDirection(DtoRecommendationPostRequest dto) {

        try(
                var env = OrtEnvironment.getEnvironment();
                var session = env.createSession(resourceLoader.getResource(PATH_ONNX_MODEL).getContentAsByteArray(), new OrtSession.SessionOptions());
                var input = OnnxTensor.createTensor(env, onnxMapper.toML(dto));
                var results = session.run(Map.of(firstElement(session.getInputNames()), input))
        ) {
            Map<String, Float> next = (HashMap<String, Float>)((Collection<OnnxMap>) results.get(1).getValue()).iterator().next().getValue();

            return next.entrySet().stream()
                    .sorted(Map.Entry.<String, Float>comparingByValue().reversed())
                    .limit(3)
                    .map(entry -> this.getDirection(entry.getKey()))
                    .toList();
        } catch (OrtException | IOException ignored) {}

        throw new ServiceUnavailableException();
    }
}
