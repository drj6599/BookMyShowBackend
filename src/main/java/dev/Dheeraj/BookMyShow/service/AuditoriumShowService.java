package dev.Dheeraj.BookMyShow.service;

import dev.Dheeraj.BookMyShow.model.AuditoriumShow;
import dev.Dheeraj.BookMyShow.repository.AuditoriumShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditoriumShowService {
    @Autowired
    private AuditoriumShowRepository auditoriumShowRepository;

    public AuditoriumShow getById(int id){
        return auditoriumShowRepository.findById(id).get();
    }
}
