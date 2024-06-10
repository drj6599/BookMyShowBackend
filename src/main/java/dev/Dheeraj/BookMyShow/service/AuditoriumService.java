package dev.Dheeraj.BookMyShow.service;

import dev.Dheeraj.BookMyShow.model.Auditorium;
import dev.Dheeraj.BookMyShow.model.Theatre;
import dev.Dheeraj.BookMyShow.model.constant.AuditoriumFeatures;
import dev.Dheeraj.BookMyShow.repository.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuditoriumService {
    @Autowired
    private AuditoriumRepository auditoriumRepository;

    @Autowired
    private TheatreService theatreService;

    public Auditorium addAuditorium(int theatreId, String name, int capacity, List<String> audiFeatures){
        Auditorium auditorium = new Auditorium();
        auditorium.setName(name);
        auditorium.setCapacity(capacity);
        List<AuditoriumFeatures> features = new ArrayList<>();
        for (String f: audiFeatures) {
            features.add(AuditoriumFeatures.valueOf(f));
        }
        auditorium.setAuditoriumFeatures(features);
        auditorium.setAuditoriumShows(new ArrayList<>());
        auditorium.setSeats(new ArrayList<>());
        Theatre theatre = theatreService.getTheatreById(theatreId);
        List<Auditorium> audis = theatre.getAuditoriums();
        audis.add(auditorium);
        theatre.setAuditoriums(audis);
        auditoriumRepository.save(auditorium);
        theatreService.saveTheatre(theatre); // upsert operation :- insert + update
        return auditorium;
    }

    public Auditorium getById(int id){
        return auditoriumRepository.findById(id).get();
    }

    public void update(Auditorium audi){
        auditoriumRepository.save(audi);
    }
}
