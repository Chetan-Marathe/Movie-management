package com.movie.movieApplication.service;

import com.movie.movieApplication.entity.Star;
import com.movie.movieApplication.repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StarService {

    @Autowired
    private StarRepository starRepository;

    public List<Star> Findall(){
        return starRepository.findAll();
    }

    public Star FindaStar(Long id){
        Star star;
        star = starRepository.findById(id).orElseThrow(()-> new RuntimeException("Stars not found "));
        return star;
    }

    public void CreateStar( Star star){
        starRepository.save(star);
    }

    public void UpdateStar(Star star){
        starRepository.save(star);
    }
    public void Deletestar(Long id){
        Star star;
        star = starRepository.findById(id).orElseThrow(()-> new RuntimeException("Stars not found "));
        starRepository.deleteById(star.getId());
    }

}
