package com.webcuser.security.controllers;

import com.webcuser.security.models.Category;
import com.webcuser.security.models.dto.CategoryDto;
import com.webcuser.security.servicies.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping(path = "/api/v1/protected/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public List<Category> getAllCategories(){
        return this.categoryService.getAllCategories();
    }
    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable("id") Long id){
        return this.categoryService.getCategoryById(id);
    }
    @PostMapping("/")
    public Category storeCategory(@RequestBody CategoryDto request) {
        return this.categoryService.storeCategory(request);
    }
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable("id") Long id, @RequestBody CategoryDto request){
        return this.categoryService.updateCategory(id, request);
    }
    @DeleteMapping("/{id}")
    public Category deleteCategory(@PathVariable("id") Long id){
        return this.categoryService.deleteCategory(id);
    }
}
