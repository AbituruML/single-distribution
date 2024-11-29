package ru.recommendation_system.recommendation_system_backend.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RecommendationRepository {
    private ConcurrentHashMap<String, String> studyDirections;

    @PostConstruct
    public void init() {
        studyDirections = new ConcurrentHashMap<>();

        studyDirections.put("Информатика и вычислительная техника", "09.03.01");
        studyDirections.put("Информационные системы и технологии", "09.03.02");
        studyDirections.put("Прикладная информатика", "09.03.03");
        studyDirections.put("Программная инженерия", "09.03.04");
        studyDirections.put("Информационная безопасность", "10.03.01");
        studyDirections.put("Информационная безопасность автоматизированных систем", "10.05.03");
        studyDirections.put("Приборостроение", "12.03.01");
        studyDirections.put("Биотехнические системы и технологии", "12.03.04");
        studyDirections.put("Управление в технических системах", "27.03.04");
    }

    public Map<String, String> getAllStudyDirections() {
        return new HashMap<>(studyDirections);
    }

    public String getStudyDirectionCode(String direction) {
        return studyDirections.get(direction);
    }
}
