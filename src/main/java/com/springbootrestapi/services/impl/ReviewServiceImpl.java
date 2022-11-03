package com.springbootrestapi.services.impl;

import com.springbootrestapi.exception.ResourceNotFoundException;
import com.springbootrestapi.models.Review;
import com.springbootrestapi.repository.CategoryRepository;
import com.springbootrestapi.repository.ReviewRepository;
import com.springbootrestapi.repository.UserRepository;
import com.springbootrestapi.services.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}
