package com.depromeet.team5.service;

import com.depromeet.team5.domain.review.ReviewUpdateValue;
import com.depromeet.team5.domain.review.Review;
import com.depromeet.team5.domain.review.ReviewCreateValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewService {

    void saveReview(ReviewCreateValue reviewCreateValue, Long userId, Long storeId);

    Page<Review> getAllByUser(Long userId, Pageable pageable);

    Review update(Long userId, Long reviewId, ReviewUpdateValue reviewUpdateValue);

    void delete(Long userId, Long reviewId);
}
