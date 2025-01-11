package com.movie.movieApplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="director")
public class Director{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="name",nullable = false,length =50,unique = true)
    public String name;

    @Column(name="description",nullable = false,length = 250)
    public String description;

    @ManyToMany(mappedBy = "director",cascade = CascadeType.ALL)
    public Set<Movie> movies = new HashSet<Movie>();

    public Director(){
    }

    public Director(Long id, String name, String description, Set<Movie> movies) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.movies = movies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Director(String name,String description){
        this.name=name;
        this.description=description;
    }
}
