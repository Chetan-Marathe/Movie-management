package com.movie.movieApplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="name",nullable = false,length = 100,unique = true)
    public String name;

    @Column(name="description",nullable = false,length = 250)
    public String description;

    //    Now we will Create the mapping

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="movies_categories",
        joinColumns = {@JoinColumn(name="movie_id")},
        inverseJoinColumns = {@JoinColumn(name="categories_id")}     )
    public Set<Category> categories = new HashSet<Category>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="movies_director",
            joinColumns = {@JoinColumn(name="movie_id")},
            inverseJoinColumns = {@JoinColumn(name="director_id")}     )
    public Set<Director> director = new HashSet<Director>();


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="movies_stars",
            joinColumns = {@JoinColumn(name="movie_id")},
            inverseJoinColumns = {@JoinColumn(name="stars_id")}     )
    public Set<Star> stars = new HashSet<Star>();

    //Now we will write some methods of the execution of the bidirectional mapping

    public void removeCategory(Category category){
          //removes the category from the current category list
          this.categories.remove(category);
          //removes the category from each associated movie list
          category.getMovies().remove(category);
    }

    public void addCategory(Category category){
        this.categories.add(category);
        category.getMovies().add(this);
    }

    public void removeDirector(Director director){
        this.director.remove(director);
        director.getMovies().remove(director);
    }

    public void addDirector(Director director){
        this.director.add(director);
        director.getMovies().add(this);
    }

    public void removeStar(Star star){
        this.stars.remove(star);
        star.getMovies().remove(star);
    }

    public void addStar(Star star){
        this.stars.add(star);
        star.getMovies().add(this);
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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Director> getDirector() {
        return director;
    }

    public void setDirector(Set<Director> director) {
        this.director = director;
    }

    public Set<Star> getStars() {
        return stars;
    }

    public void setStars(Set<Star> stars) {
        this.stars = stars;
    }

    public Movie(Long id, String name, String description, Set<Category> categories, Set<Director> director, Set<Star> stars) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.categories = categories;
        this.director = director;
        this.stars = stars;
    }

    public Movie(){

    }
}
