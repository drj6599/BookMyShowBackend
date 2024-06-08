package dev.Dheeraj.BookMyShow.service;

import dev.Dheeraj.BookMyShow.model.AuditoriumShowSeat;
import dev.Dheeraj.BookMyShow.repository.AuditoriumShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriumShowSeatService {
    @Autowired
    private AuditoriumShowSeatRepository auditoriumShowSeatRepository;

    public AuditoriumShowSeat getShowSeat(int showSeatId){
        return auditoriumShowSeatRepository.findById(showSeatId).get();
    }

    public AuditoriumShowSeat saveShowSeat(AuditoriumShowSeat auditoriumShowSeat){
        return auditoriumShowSeatRepository.save(auditoriumShowSeat);
    }
}
