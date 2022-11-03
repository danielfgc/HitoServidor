package com.springbootrestapi.controllers;

import com.springbootrestapi.models.Review;
import com.springbootrestapi.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @PostMapping()
    public ResponseEntity<Review> createReview(@RequestBody Review review){
        return new ResponseEntity<Review>(reviewService.createReview(review), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }

}
