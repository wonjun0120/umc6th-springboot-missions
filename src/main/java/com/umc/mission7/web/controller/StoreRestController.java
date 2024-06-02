package com.umc.mission7.web.controller;

import com.umc.mission7.apiPayload.ApiResponse;
import com.umc.mission7.converter.StoreConverter;
import com.umc.mission7.domain.Review;
import com.umc.mission7.domain.Store;
import com.umc.mission7.service.storeService.StoreCommandService;
import com.umc.mission7.validation.annotation.ExistStore;
import com.umc.mission7.validation.annotation.ExistUser;
import com.umc.mission7.web.dto.StoreRequestDTO;
import com.umc.mission7.web.dto.StoreResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/create")
    public ApiResponse<StoreResponseDTO.CreateStoreResultDTO> createStore(@RequestBody @Valid StoreRequestDTO.CreateDTO request){
        System.out.println(request.toString());
        Store store = storeCommandService.createStore(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateStoreResultDTO(store));
    }

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.CreateReviewResultDTO> createReview(@RequestBody @Valid StoreRequestDTO.ReviewDTO request,
                                                                            @ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                            @ExistUser @RequestParam(name = "userId") Long userId) {

        Review review = storeCommandService.createReview(userId, storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreateReviewResultDTO(review));

    }
}
