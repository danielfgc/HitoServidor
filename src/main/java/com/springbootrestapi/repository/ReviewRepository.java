package com.springbootrestapi.repository;

import com.springbootrestapi.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
