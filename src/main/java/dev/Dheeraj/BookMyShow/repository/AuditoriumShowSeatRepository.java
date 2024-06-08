package dev.Dheeraj.BookMyShow.repository;

import dev.Dheeraj.BookMyShow.model.AuditoriumShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumShowSeatRepository extends JpaRepository<AuditoriumShowSeat,Integer> {
}
