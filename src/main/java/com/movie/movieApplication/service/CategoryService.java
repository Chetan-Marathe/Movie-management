package com.movie.movieApplication.service;

import com.movie.movieApplication.entity.Category;
import com.movie.movieApplication.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> FindAll(){
        return categoryRepository.findAll();
    }

    public Category FindaCategory(Long id){
         Category category;
         category = categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Cateory not found"));
         return category;
    }

    public void CreateCategory(Category category){
        categoryRepository.save(category);
    }

    public void Updatecategory(Category category){
        categoryRepository.save(category);
    }
    public void DeleteCategory(Long id){
        Category category;
        category = categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Cateory not found"));
        categoryRepository.deleteById(category.getId());
    }
}
