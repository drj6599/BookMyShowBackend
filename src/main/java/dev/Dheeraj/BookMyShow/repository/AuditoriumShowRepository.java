package dev.Dheeraj.BookMyShow.repository;

import dev.Dheeraj.BookMyShow.model.AuditoriumShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumShowRepository extends JpaRepository<AuditoriumShow,Integer> {
}
