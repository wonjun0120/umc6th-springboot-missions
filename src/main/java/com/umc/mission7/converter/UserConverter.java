package com.umc.mission7.converter;

import com.umc.mission7.domain.Gender;
import com.umc.mission7.domain.User;
import com.umc.mission7.domain.UserMission;
import com.umc.mission7.web.dto.UserRequestDTO;
import com.umc.mission7.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {
    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user){
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(UserRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
        }

        return User.builder()
                .address(request.getAddress())
                .gender(gender)
                .name(request.getName())
                .email(request.getEmail())
                .nickName(request.getNickName())
                .userFoodCategories(new ArrayList<>())
                .birth(request.getBirth())
                .isAgreeLocation(request.getIsAgreeLocation())
                .isAgreeMarketing(request.getIsAgreeMarketing())
                .point(request.getPoint())
                .build();
    }

    public static UserMission toUserMission(UserRequestDTO.addMissionDTO request) {
        return UserMission.builder()
                .startDate(request.getStartDate())
                .dueDate(request.getDueDate())
                .build();
    }

    public static UserResponseDTO.addMissionResultDTO addMissionDTO(UserMission mission) {
        return UserResponseDTO.addMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
