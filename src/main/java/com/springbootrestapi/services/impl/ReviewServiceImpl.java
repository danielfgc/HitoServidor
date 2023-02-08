package com.springbootrestapi.services.impl;

import com.springbootrestapi.exception.ResourceNotFoundException;
import com.springbootrestapi.models.Category;
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

    @Override
    public List<Review> getReviewsByCategory(String category) {
        return reviewRepository.findByCategory(category);
    }

    @Override
    public Review updateReview(Review review, int id) {
        Review reviewExists = reviewRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Review","id", id));
        reviewExists.setBody(review.getBody());
        reviewExists.setTitle(review.getTitle());
        reviewExists.setCategory(review.getCategory());
        reviewExists.setTitle(review.getTitle());
        reviewExists.setValoration(review.getValoration());
        reviewExists.setLikes(review.getLikes());
        reviewExists.setDislikes(review.getDislikes());
        reviewRepository.save(reviewExists);
        return reviewExists;
    }

    @Override
    public void deleteReview(int id) {
        reviewRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Review","id", id));
        reviewRepository.deleteById(id);

    }

}
