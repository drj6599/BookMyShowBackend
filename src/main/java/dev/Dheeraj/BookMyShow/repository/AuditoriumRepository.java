package dev.Dheeraj.BookMyShow.repository;

import dev.Dheeraj.BookMyShow.model.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium , Integer> {
}
