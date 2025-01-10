package com.movie.movieApplication.service;

import com.movie.movieApplication.entity.Director;
import com.movie.movieApplication.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    public List<Director> FindAll(){
        return directorRepository.findAll();
    }

    public Director FindaDirector(Long id){
        Director director;
        director = directorRepository.findById(id).orElseThrow(()->new RuntimeException("Director is not found"));
        return director;
    }

    public void CreateDirector(Director director){
        directorRepository.save(director);
    }
    public void UpdateDirector(Director director){
        directorRepository.save(director);
    }

    public void DeleteDirector(Long id){
        Director director;
        director = directorRepository.findById(id).orElseThrow(()->new RuntimeException("Director is not found"));
        directorRepository.deleteById(director.getId());
    }
}
