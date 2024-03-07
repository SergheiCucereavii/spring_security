package com.webcuser.security.servicies.category;

import com.webcuser.security.models.Category;
import com.webcuser.security.models.Post;
import com.webcuser.security.models.dto.CategoryDto;
import com.webcuser.security.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category storeCategory(CategoryDto request) {
        Category category = new Category();
        category.setName(request.name);
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category updateCategory(Long id, CategoryDto request) {
        Optional<Category> category = categoryRepository.findById(id);
        Category categoryItem = category.get();
        categoryItem.setName(request.name);
        return categoryRepository.save(categoryItem);
    }

    @Override
    public Category deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) { categoryRepository.deleteById(id);}
        return category;
    }


}
