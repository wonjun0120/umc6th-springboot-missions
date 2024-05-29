package com.umc.mission7.service.foodCategoryService;

import com.umc.mission7.repository.FoodCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodCategoryService {

    private final FoodCategoryRepository foodCategoryRepository;

    public boolean existsById(Long id) {
        return foodCategoryRepository.existsById(id);
    }
}