package com.movie.movieApplication;

import com.movie.movieApplication.entity.Category;
import com.movie.movieApplication.entity.Director;
import com.movie.movieApplication.entity.Movie;
import com.movie.movieApplication.entity.Star;
import com.movie.movieApplication.service.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(MovieService movieService){
		return args -> {
			Movie movie1 = new Movie("Three Idiots","Engineering experience is told");
			Category category1 = new Category("Science and fun");
			Director director1 = new Director("Rajkumar Hirani","An amazing director");
			Star star1 = new Star("Amir khan, Kareena kappor");
			movie1.addCategory(category1);
			movie1.addDirector(director1);
			movie1.addStar(star1);
			movieService.CreateMovie(movie1);

			Movie movie2= new Movie("Sanam Teri Kasam","Cancer Story");
			Category category2= new Category("Romantic");
			Director director2= new Director("Radhika Rao","Also an amazing director");
			Star star2= new Star("Harshawardhan Rane ,Moura Housaain");
			movie1.addCategory(category2);
			movie1.addDirector(director2);
			movie1.addStar(star2);
			movieService.CreateMovie(movie2);

			Movie movie3= new Movie("Anand","Enjoy through the pain");
			Category category3= new Category("Happiness");
			Director director3= new Director("Hrishikesh Mukherjii","An amazing director");
			Star star3= new Star("Rajesh khanna,Amitabh Bacchan");
			movie1.addCategory(category3);
			movie1.addDirector(director3);
			movie1.addStar(star3);
			movieService.CreateMovie(movie3);

			 };}}
