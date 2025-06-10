package com.example.text_generator.services;

import com.example.text_generator.models.Category;
import com.example.text_generator.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category addCategory(Category newCategory) {
        return categoryRepository.save(newCategory);
    }
}
