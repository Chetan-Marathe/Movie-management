package com.movie.movieApplication.service;

import com.movie.movieApplication.entity.Movie;
import com.movie.movieApplication.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> FindAllMovies(){
        return movieRepository.findAll();
    }

    public Movie FindaMovie(Long id){
        Movie movie;
        movie= movieRepository.findById(id).orElseThrow(()-> new RuntimeException("Movie not found"));
        return movie;
    }

    public void CreateMovie(Movie movie){
        movieRepository.save(movie);
    }

    public void UpdateMovie(Movie movie){
        movieRepository.save(movie);
    }

    public void DeleteMovie(Long id){
        Movie movie;
        movie= movieRepository.findById(id).orElseThrow(()-> new RuntimeException("Movie not found"));
        movieRepository.deleteById(movie.getId());
    }
}
