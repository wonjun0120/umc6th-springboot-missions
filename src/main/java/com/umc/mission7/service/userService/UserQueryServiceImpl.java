package com.umc.mission7.service.userService;

import com.umc.mission7.domain.User;
import com.umc.mission7.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryServiceImpl implements UserQueryService{
    private final UserRepository userRepository;

    @Override
    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
    }
}
