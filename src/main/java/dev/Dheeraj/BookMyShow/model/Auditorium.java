package dev.Dheeraj.BookMyShow.model;

import dev.Dheeraj.BookMyShow.model.constant.AuditoriumFeatures;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel{
    private String name;
    private int capacity;
    @OneToMany
    private List<AuditoriumShow> shows;
    @OneToMany
    private List<AuditoriumSeat> seats;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<AuditoriumFeatures> auditoriumFeatures;
}
