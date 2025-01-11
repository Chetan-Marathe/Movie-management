package com.movie.movieApplication.controller;

import com.movie.movieApplication.entity.Category;
import com.movie.movieApplication.entity.Movie;
import com.movie.movieApplication.service.CategoryService;
import com.movie.movieApplication.service.DirectorService;
import com.movie.movieApplication.service.MovieService;
import com.movie.movieApplication.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    DirectorService directorService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    StarService starService;

    @GetMapping("/movies")
    public String FindallMovies(Model model){
        List<Movie> movies = movieService.FindAllMovies();
        model.addAttribute("movies",movies);
        return "movies";
    }

    @GetMapping("movie/{id}")
    public String FindaMovie(@PathVariable Long id,Model model){
        Movie movie = movieService.FindaMovie(id);
        model.addAttribute("movie",movie);
        return "list-movie";
    }
    @GetMapping("remove-movie/{id}")
    public String deletemovie(@PathVariable Long id,Model model){
        movieService.DeleteMovie(id);
        model.addAttribute("movies",movieService.FindAllMovies());
        return "movies";
    }

    @GetMapping("update-movie/{id}")
    public String UpdateMovie(@PathVariable Long id,Model model){
        Movie movie = movieService.FindaMovie(id);
        model.addAttribute("movie",movie);
        model.addAttribute("categories",categoryService.FindAll());
        model.addAttribute("director",directorService.FindAll());
        model.addAttribute("stars",starService.Findall());
        return "update-movie";
    }

    @PostMapping("/save-update/{id}")
    public String updatemovie(@PathVariable Long id,@ModelAttribute("movie") Movie movie,BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("categories",categoryService.FindAll());
            model.addAttribute("director",directorService.FindAll());
            model.addAttribute("stars",starService.Findall());
            return "update-movie";
        }
         Movie existingmovie = movieService.FindaMovie(id);
            existingmovie.setName(movie.getName());
            existingmovie.setDescription(movie.getDescription());
            existingmovie.setCategories(movie.getCategories());
            existingmovie.setStars(movie.getStars());
            existingmovie.setDirector(movie.getDirector());

            movieService.UpdateMovie(movie);
            return "redirect:/movies";
    }

        @GetMapping("/add-movie")
        public String addMovie(Movie movie, Model model){

            model.addAttribute("categories",categoryService.FindAll());
            model.addAttribute("director",directorService.FindAll());
            model.addAttribute("stars",starService.Findall());
            return "add-movie";
        }

        @PostMapping("/save-movie")
        public String saveMovie(Movie movie,BindingResult result,Model model){
            if(result.hasErrors()){
                return "add-movie";
            }
            movieService.CreateMovie(movie);
            model.addAttribute("movies",movieService.FindAllMovies());
            return "redirect:/movies";
        }













}
