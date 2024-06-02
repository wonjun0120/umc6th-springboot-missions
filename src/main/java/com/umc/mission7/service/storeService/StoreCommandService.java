package com.umc.mission7.service.storeService;


import com.umc.mission7.domain.Review;
import com.umc.mission7.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReviewDTO request);
}
