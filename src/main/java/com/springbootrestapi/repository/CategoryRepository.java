package com.springbootrestapi.repository;

import com.springbootrestapi.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
