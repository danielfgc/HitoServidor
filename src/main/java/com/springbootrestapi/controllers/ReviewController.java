package com.springbootrestapi.controllers;

import com.springbootrestapi.models.Category;
import com.springbootrestapi.models.Review;
import com.springbootrestapi.models.ReviewReq;
import com.springbootrestapi.models.User;
import com.springbootrestapi.services.CategoryService;
import com.springbootrestapi.services.ReviewService;
import com.springbootrestapi.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin()
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private ReviewService reviewService;
    private UserService userService;
    private CategoryService categoryService;

    public ReviewController(ReviewService reviewService, UserService userService, CategoryService categoryService) {
        this.reviewService = reviewService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @PostMapping()
    public ResponseEntity<Review> createReview(@RequestBody ReviewReq reviewreq){
        Review review = reviewreq.getReview();
        User user = userService.getOneUser(reviewreq.getIdUser());
        Category category = categoryService.getOneCategory(reviewreq.getIdCategory());
        review.setUser(user);
        review.setCategory(category);
        return new ResponseEntity<Review>(reviewService.createReview(review), HttpStatus.CREATED);
    }
    @GetMapping()
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @GetMapping("{id}")
    public ResponseEntity<Review> getOneUser(@PathVariable("id") int id){
        return new ResponseEntity<Review>(reviewService.getOneReview(id), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Review> updateReview(@PathVariable("id") int id, @RequestBody Review review){
        return new ResponseEntity<Review>(reviewService.updateReview(review, id),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteReview(@PathVariable("id") int id){
        reviewService.deleteReview(id);
        return new ResponseEntity<String>("Review deleted successfully", HttpStatus.OK);
    }

}
