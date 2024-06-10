package dev.Dheeraj.BookMyShow.service;

import dev.Dheeraj.BookMyShow.model.Actor;
import dev.Dheeraj.BookMyShow.model.Movie;
import dev.Dheeraj.BookMyShow.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private MovieService movieService;

    public Actor createActor(String name){
        Actor actor = new Actor();
        actor.setName(name);
        actorRepository.save(actor);
        return actor;
    }

    public Actor addActorToMovie(int actorId,int movieId){
        Actor actor = actorRepository.findById(actorId).get();
        Movie movie = movieService.getById(movieId);
        actor.getMovies().add(movie);
        movie.getActors().add(actor);
        actorRepository.save(actor);
        movieService.saveMovie(movie);
        return actor;
    }
}
