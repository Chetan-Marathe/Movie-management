package com.movie.movieApplication.repository;

import com.movie.movieApplication.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director,Long> {
}
