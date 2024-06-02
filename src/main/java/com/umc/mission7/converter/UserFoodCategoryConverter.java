package com.umc.mission7.converter;

import com.umc.mission7.domain.FoodCategory;
import com.umc.mission7.domain.UserFoodCategory;

import java.util.List;
import java.util.stream.Collectors;

public class UserFoodCategoryConverter {
    public static List<UserFoodCategory> toUserFoodCategory(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        UserFoodCategory.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
