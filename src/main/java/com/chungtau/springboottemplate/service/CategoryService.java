package com.chungtau.springboottemplate.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chungtau.springboottemplate.exception.EntityRuntimeException;
import com.chungtau.springboottemplate.model.category.Category;
import com.chungtau.springboottemplate.model.category.CreateCategoryInput;
import com.chungtau.springboottemplate.model.category.UpdateCategoryInput;
import com.chungtau.springboottemplate.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Optional<Category> getCategoryById(String id) {
        if(id != null){
            return categoryRepository.findById(id);
        }else{
            return Optional.empty();
        }
    }

    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category createCategory(CreateCategoryInput input) {
        Category category = new Category();
        category.setName(input.getName());
        category.setDescription(input.getDescription());
        return categoryRepository.save(category);
    }

    @SuppressWarnings("null")
    public Category updateCategory(UpdateCategoryInput input) {
        Optional<Category> optionalCategory = getCategoryById(input.getId());
        Category category = optionalCategory.orElseThrow(() -> EntityRuntimeException.notFound(Category.class, input.getId()));
        
        if (input.getName() != null && !input.getName().isEmpty()) {
            category.setName(input.getName());
        }
    
        if (input.getDescription() != null && !input.getDescription().isEmpty()) {
            category.setDescription(input.getDescription());
        }
        return categoryRepository.save(category);
    }

    public boolean deleteCategory(String id) {
        if (id == null || id.isEmpty() || !categoryRepository.existsById(id)) {
            return false;
        }
    
        categoryRepository.deleteById(id);
        return true; 
    }
}
