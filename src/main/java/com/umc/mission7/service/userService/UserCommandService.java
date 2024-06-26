package com.umc.mission7.service.userService;

import com.umc.mission7.domain.User;
import com.umc.mission7.domain.UserMission;
import com.umc.mission7.web.dto.UserRequestDTO;

public interface UserCommandService {
    User joinUser(UserRequestDTO.JoinDto request);

    UserMission addMission(Long userId, Long missionId, UserRequestDTO.addMissionDTO request);
}
