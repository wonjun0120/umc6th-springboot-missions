package com.umc.mission7.service.storeService;

import com.umc.mission7.converter.StoreConverter;
import com.umc.mission7.domain.Review;
import com.umc.mission7.repository.ReviewRepository;
import com.umc.mission7.repository.StoreRepository;
import com.umc.mission7.repository.UserRepository;
import com.umc.mission7.web.dto.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{
    private final ReviewRepository reviewRepository;

    private final UserRepository userRepository;

    private final StoreRepository storeRepository;

    @Override
    public Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReviewDTO request) {

        Review review = StoreConverter.toReview(request);

        review.setUser(userRepository.findById(memberId).get());
        review.setStore(storeRepository.findById(storeId).get());

        return reviewRepository.save(review);
    }
}
