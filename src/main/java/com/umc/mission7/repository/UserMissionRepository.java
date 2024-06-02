package com.umc.mission7.repository;

import com.umc.mission7.domain.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
}
