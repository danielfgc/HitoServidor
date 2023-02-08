package com.springbootrestapi.repository;

import com.springbootrestapi.models.Category;
import com.springbootrestapi.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query("Select r from Review r where r.category = ?1")
    List<Review> findByCategory(String category);
}
