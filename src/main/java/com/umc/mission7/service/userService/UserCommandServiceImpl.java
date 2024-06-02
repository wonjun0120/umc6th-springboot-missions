package com.umc.mission7.service.userService;

import com.umc.mission7.apiPayload.code.exception.handler.FoodCategoryHandler;
import com.umc.mission7.apiPayload.code.status.ErrorStatus;
import com.umc.mission7.converter.UserConverter;
import com.umc.mission7.converter.UserFoodCategoryConverter;
import com.umc.mission7.domain.FoodCategory;
import com.umc.mission7.domain.User;
import com.umc.mission7.domain.UserFoodCategory;
import com.umc.mission7.repository.FoodCategoryRepository;
import com.umc.mission7.repository.UserRepository;
import com.umc.mission7.web.dto.UserRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDto request) {

        User newUser = UserConverter.toUser(request);
        List<FoodCategory> foodCategoryList = request.getUserFoodCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category)
                            .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<UserFoodCategory> userFoodCategoryList = UserFoodCategoryConverter.toUserFoodCategory(foodCategoryList);

        userFoodCategoryList.forEach(userFoodCategory -> {userFoodCategory.setUser(newUser);});

        return userRepository.save(newUser);
    }
}
