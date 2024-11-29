package ru.recommendation_system.recommendation_system_backend.domain.mapper;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;
import ru.recommendation_system.recommendation_system_backend.model.DtoRecommendationPostRequest;

import java.util.ArrayList;
import java.util.List;

@Service
public class ONNXMapper {
    public float[][] toML(DtoRecommendationPostRequest dto) {
//        var input_arr = new float[][]{{1f, 242.73666f,1f,1f,0f,0f,
//                1f,1f,0f,0f,0f,0f,0f,3f,1f,2f,2f,1f,3f,1f,3f,2f,2f,1f,
//                1f,1f,0f,0f,0f,1f,0f,0f,0f,0f,0f,0f}};

        List<Float> inputArrOne = new ArrayList<>();
        inputArrOne.add(mapGender(dto.getGender()));
        inputArrOne.add(dto.getSumUseScore().floatValue());
        // OLYMPIADS
        inputArrOne.add(mapBoolean(dto.getOlympiads().getMathematics()));
        inputArrOne.add(mapBoolean(dto.getOlympiads().getComputerScience()));
        inputArrOne.add(mapBoolean(dto.getOlympiads().getPhysics()));
        // HOBBIES
        inputArrOne.add(mapBoolean(dto.getHobbies().getGameDevelopment()));
        inputArrOne.add(mapBoolean(dto.getHobbies().getSport()));
        inputArrOne.add(mapBoolean(dto.getHobbies().getProgramming()));
        inputArrOne.add(mapBoolean(dto.getHobbies().getRobotics()));
        inputArrOne.add(mapBoolean(dto.getHobbies().get3dModeling()));
        inputArrOne.add(mapBoolean(dto.getHobbies().getMathematics()));
        inputArrOne.add(mapBoolean(dto.getHobbies().getCreativity()));
        inputArrOne.add(mapBoolean(dto.getHobbies().getPhysics()));

        // LIKES
        inputArrOne.add(mapInteger(dto.getLikes().getWebDevelopment()));
        inputArrOne.add(mapInteger(dto.getLikes().getSystemAdministration()));
        inputArrOne.add(mapInteger(dto.getLikes().getMathematics()));
        inputArrOne.add(mapInteger(dto.getLikes().getHardware()));
        inputArrOne.add(mapInteger(dto.getLikes().getBiology()));
        inputArrOne.add(mapInteger(dto.getLikes().getDataScience()));
        inputArrOne.add(mapInteger(dto.getLikes().getDesign()));
        inputArrOne.add(mapInteger(dto.getLikes().getBackendDevelopment()));
        inputArrOne.add(mapInteger(dto.getLikes().getFrontendDevelopment()));
        inputArrOne.add(mapInteger(dto.getLikes().getEconomy()));
        inputArrOne.add(mapInteger(dto.getLikes().getHacking()));

        inputArrOne.add(mapBoolean(dto.getUniWasMyDecision()));
        inputArrOne.add(mapBoolean(dto.getIsGradesImportant()));

        addPreferredItJob(inputArrOne, dto.getPreferredItJob());

        return new float[][] {ArrayUtils.toPrimitive(inputArrOne.toArray(Float[]::new))};
    };


    private float mapGender(DtoRecommendationPostRequest.GenderEnum genderEnum) {
        return switch (genderEnum) {
            case MALE -> 1f;
            case FEMALE -> 0f;
        };
    }

    private float mapBoolean(boolean bool){
        return bool ? 1f : 0f;
    }

    private float mapInteger(Integer i) {
        return (float)i;
    }

    private void addPreferredItJob(List<Float> target, DtoRecommendationPostRequest.PreferredItJobEnum preferredItJobEnum){
        int position = switch (preferredItJobEnum) {
            case QA -> 0;
            case DATA_ANALYTICS -> 1;
            case WEB_DEVELOPMENT -> 2;
            case ARTIFICIAL_INTELLIGENCE_AND_MACHINE_LEARNING -> 3;
            case CYBERSECURITY -> 4;
            case MOBILE_DEVELOPMENT -> 5;
            case DEVOPS -> 6;
            case DESIGN_UI_UX -> 7;
            case GAME_DEVELOPMENT -> 8;
            case SYSTEMS_PROGRAMMING -> 9;
        };
        for (int i =0; i < DtoRecommendationPostRequest.PreferredItJobEnum.values().length; i++){
          target.add(mapBoolean(i==position));
        }
    }
}
