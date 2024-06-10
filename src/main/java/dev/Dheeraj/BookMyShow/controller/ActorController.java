package dev.Dheeraj.BookMyShow.controller;

import dev.Dheeraj.BookMyShow.dto.ActorRequestDto;
import dev.Dheeraj.BookMyShow.dto.ActorResponseDto;
import dev.Dheeraj.BookMyShow.dto.ActorToMovieDto;
import dev.Dheeraj.BookMyShow.model.Actor;
import dev.Dheeraj.BookMyShow.model.Movie;
import dev.Dheeraj.BookMyShow.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ActorController {
    @Autowired
    private ActorService actorService;

    @PostMapping("/createActor")
    public ResponseEntity createActor(@RequestBody ActorRequestDto actorRequestDto){
        return ResponseEntity.ok(
                actorService.createActor(actorRequestDto.getName())
        );
    }

    @PostMapping("/addActorToMovie")
    @ResponseBody
    public ResponseEntity addActorToMovie(@RequestBody ActorToMovieDto dto){

        Actor actor = actorService.addActorToMovie(dto.getActorId(), dto.getMovieId());
        List<String> movies = new ArrayList<>();
        for (Movie movie : actor.getMovies()){
            movies.add(movie.getName());
        }
        return ResponseEntity.ok(
                new ActorResponseDto(actor.getName(),movies)
        );
    }
}
