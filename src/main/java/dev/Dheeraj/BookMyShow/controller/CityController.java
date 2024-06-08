package dev.Dheeraj.BookMyShow.controller;

import dev.Dheeraj.BookMyShow.dto.CityRequestDto;
import dev.Dheeraj.BookMyShow.dto.CityResponseDto;
import dev.Dheeraj.BookMyShow.exception.InvalidCityNameException;
import dev.Dheeraj.BookMyShow.model.City;
import dev.Dheeraj.BookMyShow.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping("/addCity")
    @ResponseBody
    public CityResponseDto createCity(@RequestBody CityRequestDto cityRequestDto){
        try{
            String cityName = cityRequestDto.getName();
            if(cityName.isEmpty() || cityName.isBlank() || cityName.length() == 0 || cityName == null){
                throw new InvalidCityNameException("City Name is Invalid.");
            }
            City savedCity = cityService.saveCity(cityName);
            return new CityResponseDto(savedCity.getId(),savedCity.getName());
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/deleteCity/{id}")
    public ResponseEntity deleteCity(@PathVariable("id") int cityId){
        boolean isDeleted = cityService.deleteCity(cityId);
        return ResponseEntity.ok(isDeleted);
    }

    @GetMapping("/city/{name}")
    public ResponseEntity getCityByName(@PathVariable("name") String cityName){
        City city = cityService.findByName(cityName);
        return ResponseEntity.ok(city);
    }
}
