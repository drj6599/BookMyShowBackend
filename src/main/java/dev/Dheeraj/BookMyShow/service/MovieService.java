package dev.Dheeraj.BookMyShow.service;

import dev.Dheeraj.BookMyShow.model.Movie;
import dev.Dheeraj.BookMyShow.model.constant.MovieFeatures;
import dev.Dheeraj.BookMyShow.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie createMovie(String name, String description, List<String> movieFeatures){
        Movie movie = new Movie();
        movie.setName(name);
        movie.setDescription(description);
        List<MovieFeatures> features = new ArrayList<>();
        for (String s : movieFeatures){
            features.add(MovieFeatures.valueOf(s));
        }
        movie.setMovieFeatures(features);
        movieRepository.save(movie);
        return movie;
    }

    public Movie getById(int movieId) {
        return movieRepository.findById(movieId).get();
    }

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }
}
