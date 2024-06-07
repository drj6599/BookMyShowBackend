package dev.Dheeraj.BookMyShow.model;

import dev.Dheeraj.BookMyShow.model.constant.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AuditoriumShowSeat extends BaseModel{
    private double price;
    @ManyToOne
    private AuditoriumShow auditoriumShow;
    @ManyToOne
    private AuditoriumSeat auditoriumSeat;
    @Enumerated(EnumType.STRING)
    private ShowSeatStatus showSeatStatus;
}
