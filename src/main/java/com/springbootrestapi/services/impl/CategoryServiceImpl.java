package com.springbootrestapi.services.impl;

import com.springbootrestapi.exception.ResourceNotFoundException;
import com.springbootrestapi.models.Category;
import com.springbootrestapi.repository.CategoryRepository;
import com.springbootrestapi.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getOneCategory(int idCategory) {
        return categoryRepository.findById(idCategory).orElseThrow(() -> new ResourceNotFoundException("category", "id",idCategory));
    }
}
