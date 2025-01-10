package com.movie.movieApplication.repository;

import com.movie.movieApplication.entity.Star;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarRepository extends JpaRepository<Star,Long> {
}
