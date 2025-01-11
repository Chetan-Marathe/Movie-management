package com.movie.movieApplication.controller;
import java.util.*;

import com.movie.movieApplication.entity.Category;
import com.movie.movieApplication.repository.CategoryRepository;
import com.movie.movieApplication.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String FindAll(Model model){
        model.addAttribute("categories",categoryService.FindAll());
        return "categories";
    }

    @GetMapping("/add-category")
    public String ShowcreateCategory(Category category){
        return "add-category";
    }

    @PostMapping("/save-category")
    public String savecategory(Category category, BindingResult result , Model model ){
        if(result.hasErrors()){
            return "add-category";
        }
        categoryService.CreateCategory(category);
        model.addAttribute("categories",categoryService.FindAll());
        return "redirect:/categories";
    }
}
