package dev.Dheeraj.BookMyShow.model;

import dev.Dheeraj.BookMyShow.model.constant.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    private LocalDateTime timeOfBooking;
    private double totalAmount;
    @OneToMany
    private List<AuditoriumShowSeat> auditoriumShowSeats;
    @ManyToOne
    private AuditoriumShow auditoriumShow;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
}
