package com.springbootrestapi.services;

import com.springbootrestapi.models.Review;

import java.util.List;

public interface ReviewService {
    Review createReview(Review review);
    List<Review> getAllReviews();
    Review updateReview(Review review, int id);
    void deleteReview(int id);
}
