package dev.Dheeraj.BookMyShow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class AuditoriumShow extends BaseModel{
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Auditorium auditorium;
    private List<AuditoriumShowSeat> auditoriumShowSeats;
}
