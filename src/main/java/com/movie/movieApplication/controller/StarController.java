package com.movie.movieApplication.controller;

import com.movie.movieApplication.entity.Star;
import com.movie.movieApplication.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StarController {

    @Autowired
    private StarService starservice;

    @GetMapping("/stars")
    public String FindallStar(Model model){
        model.addAttribute("stars",starservice.Findall());
        return "stars";
    }

}
