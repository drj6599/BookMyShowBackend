package dev.Dheeraj.BookMyShow.service;

import dev.Dheeraj.BookMyShow.model.City;
import dev.Dheeraj.BookMyShow.model.Theatre;
import dev.Dheeraj.BookMyShow.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private CityService cityService;

    public Theatre saveTheatres(String name, String address , int cityId){
        Theatre theatre = new Theatre();
        theatre.setName(name);
        theatre.setAddress(address);
        Theatre savedTheatre = theatreRepository.save(theatre);

        City city = cityService.getCityById(cityId);
        List<Theatre> theatres = city.getTheatres();
        theatres.add(savedTheatre);
        city.setTheatres(theatres);
        cityService.saveCity(city);

        return savedTheatre;
    }

    public Theatre saveTheatre(Theatre theatre){
        return theatreRepository.save(theatre);
    }

    public Theatre getTheatreById(int id){
        return theatreRepository.findById(id).get();
    }
}
