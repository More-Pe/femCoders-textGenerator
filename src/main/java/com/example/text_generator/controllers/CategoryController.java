package com.example.text_generator.controllers;

import com.example.text_generator.models.Category;
import com.example.text_generator.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
        Category category = categoryService.updateCategory(id, updatedCategory);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
