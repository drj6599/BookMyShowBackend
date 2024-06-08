package dev.Dheeraj.BookMyShow.repository;

import dev.Dheeraj.BookMyShow.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    City findCityByName(String name);
}