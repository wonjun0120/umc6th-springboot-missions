package com.umc.mission7.service.userService;

import com.umc.mission7.domain.User;

import java.util.Optional;

public interface UserQueryService {
    Optional<User> findUser(Long id);
}
