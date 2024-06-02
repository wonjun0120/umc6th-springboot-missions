package com.umc.mission7.web.controller;

import com.umc.mission7.apiPayload.ApiResponse;
import com.umc.mission7.converter.UserConverter;
import com.umc.mission7.domain.Mission;
import com.umc.mission7.domain.User;
import com.umc.mission7.domain.UserMission;
import com.umc.mission7.service.userService.UserCommandService;
import com.umc.mission7.validation.annotation.ExistMission;
import com.umc.mission7.validation.annotation.ExistStore;
import com.umc.mission7.validation.annotation.ExistUser;
import com.umc.mission7.web.dto.StoreRequestDTO;
import com.umc.mission7.web.dto.UserRequestDTO;
import com.umc.mission7.web.dto.UserResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestController {
    private final UserCommandService userCommandService;

    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDto request){
//        System.out.println(request.toString());
        User user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }

    @PostMapping("/missions")
    public ApiResponse<UserResponseDTO.addMissionResultDTO> addMission(@RequestBody @Valid UserRequestDTO.addMissionDTO request,
                                                                       @ExistUser @RequestParam(name = "userId") Long userId,
                                                                       @ExistMission @RequestParam(name = "missionId") Long missionId){
        UserMission mission = userCommandService.addMission(userId, missionId, request);
        return ApiResponse.onSuccess(UserConverter.addMissionDTO(mission));
    }
}
