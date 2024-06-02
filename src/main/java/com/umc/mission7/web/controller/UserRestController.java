package com.umc.mission7.web.controller;

import com.umc.mission7.apiPayload.ApiResponse;
import com.umc.mission7.converter.UserConverter;
import com.umc.mission7.domain.User;
import com.umc.mission7.service.userService.UserCommandService;
import com.umc.mission7.web.dto.UserRequestDTO;
import com.umc.mission7.web.dto.UserResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
