package dev.Dheeraj.BookMyShow.service;

import dev.Dheeraj.BookMyShow.exception.SeatNotAvailableException;
import dev.Dheeraj.BookMyShow.model.AuditoriumShowSeat;
import dev.Dheeraj.BookMyShow.model.Ticket;
import dev.Dheeraj.BookMyShow.model.constant.ShowSeatStatus;
import dev.Dheeraj.BookMyShow.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private AuditoriumShowSeatService auditoriumShowSeatService;

    @Transactional(isolation = Isolation.SERIALIZABLE)
     public Ticket bookTicket(List<Integer> auditoriumShowSeatIds , int userId){
        for (int id : auditoriumShowSeatIds){
            AuditoriumShowSeat seat = auditoriumShowSeatService.getShowSeat(id);
            if(!seat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new SeatNotAvailableException("Seat is not available");
            }
        }

         for (int id : auditoriumShowSeatIds){
             AuditoriumShowSeat seat = auditoriumShowSeatService.getShowSeat(id);
             seat.setShowSeatStatus(ShowSeatStatus.LOCKED);
             auditoriumShowSeatService.saveShowSeat(seat);
         }
         //write logic for payment flow
         startPayment(auditoriumShowSeatIds);
         return new Ticket();
    }

    public boolean startPayment(List<Integer> auditoriumShowSeatIds){
        return true;
    }
}
