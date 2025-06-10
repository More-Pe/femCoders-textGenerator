package com.example.text_generator.controllers;

import com.example.text_generator.models.Category;
import com.example.text_generator.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity <List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }

    @PostMapping("/category")
    public ResponseEntity <Category> addCategory(@RequestBody Category newCategory) {
        Category createdCategory = categoryService.addCategory(newCategory);
        return new ResponseEntity<Category>(createdCategory, HttpStatus.CREATED);
    }
}
