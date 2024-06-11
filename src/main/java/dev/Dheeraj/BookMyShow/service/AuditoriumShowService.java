package dev.Dheeraj.BookMyShow.service;

import dev.Dheeraj.BookMyShow.model.AuditoriumShow;
import dev.Dheeraj.BookMyShow.repository.AuditoriumShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class AuditoriumShowService {
    @Autowired
    private AuditoriumShowRepository auditoriumShowRepository;
    @Autowired
    private MovieService movieService;
    @Autowired
    private AuditoriumService auditoriumService;

    public AuditoriumShow getById(int id){
        return auditoriumShowRepository.findById(id).get();
    }

    public AuditoriumShow createData(){
        AuditoriumShow show = new AuditoriumShow();
        show.setStartTime(LocalDateTime.of(2024,07,12,18,30,00));
        show.setEndTime(LocalDateTime.of(2024,07,12,21,00,00));
        show.setMovie(movieService.getById(1));
        show.setAuditorium(auditoriumService.getById(1));
        show.setShowSeats(new ArrayList<>());
        auditoriumShowRepository.save(show);
        return show;
    }
}
