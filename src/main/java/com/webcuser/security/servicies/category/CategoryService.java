package com.webcuser.security.servicies.category;

import com.webcuser.security.models.Category;
import com.webcuser.security.models.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Long id);
    Category storeCategory(CategoryDto request);
    Category updateCategory(Long id, CategoryDto request);
    Category deleteCategory(Long id);

}
