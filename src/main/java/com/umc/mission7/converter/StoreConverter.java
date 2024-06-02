package com.umc.mission7.converter;

import com.umc.mission7.domain.Review;
import com.umc.mission7.web.dto.StoreRequestDTO;
import com.umc.mission7.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {
    public static Review toReview(StoreRequestDTO.ReviewDTO request){
        return Review.builder()
                .review(request.getReview())
                .rate(request.getRate())
                .build();
    }

    public static StoreResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review){
        return StoreResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
