package dev.Dheeraj.BookMyShow.controller;

import dev.Dheeraj.BookMyShow.dto.MovieRequestDto;
import dev.Dheeraj.BookMyShow.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/addMovie")
    public ResponseEntity createMovie(@RequestBody MovieRequestDto movieRequestDto){
        return ResponseEntity.ok(
          movieService.createMovie(
                  movieRequestDto.getName(),
                  movieRequestDto.getDescription(),
                  movieRequestDto.getMovieFeatures()
          )
        );
    }
}
