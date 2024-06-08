package dev.Dheeraj.BookMyShow.service;

import dev.Dheeraj.BookMyShow.model.City;
import dev.Dheeraj.BookMyShow.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public City saveCity(String name){
        City city = new City();
        city.setName(name);
        return cityRepository.save(city);
    }

    public boolean deleteCity(int cityId){
        cityRepository.deleteById(cityId);
        return true;
    }

    public City findByName(String cityName){
        return cityRepository.findCityByName(cityName);
    }
}
