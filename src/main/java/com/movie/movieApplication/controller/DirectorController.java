package com.movie.movieApplication.controller;
import java.util.List;

import com.movie.movieApplication.entity.Director;
import com.movie.movieApplication.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DirectorController {

    @Autowired
    private DirectorService directorService;


    @GetMapping("/directors")
    public String DisplayALLDirector(Model model){
        model.addAttribute("director",directorService.FindAll());
        return "director";
    }
}
