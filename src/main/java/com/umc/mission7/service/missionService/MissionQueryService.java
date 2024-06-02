package com.umc.mission7.service.missionService;

import com.umc.mission7.domain.Mission;

import java.util.Optional;

public interface MissionQueryService {
    Optional<Mission> findMission(Long id);
}