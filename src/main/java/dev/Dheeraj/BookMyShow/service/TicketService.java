package dev.Dheeraj.BookMyShow.service;

import dev.Dheeraj.BookMyShow.exception.PaymentFailedException;
import dev.Dheeraj.BookMyShow.exception.SeatNotAvailableException;
import dev.Dheeraj.BookMyShow.model.Auditorium;
import dev.Dheeraj.BookMyShow.model.ShowSeat;
import dev.Dheeraj.BookMyShow.model.Ticket;
import dev.Dheeraj.BookMyShow.model.constant.ShowSeatStatus;
import dev.Dheeraj.BookMyShow.model.constant.TicketStatus;
import dev.Dheeraj.BookMyShow.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ShowSeatService showSeatService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private AuditoriumShowService auditoriumShowService;

    @Transactional(isolation = Isolation.SERIALIZABLE)
     public Ticket bookTicket(List<Integer> auditoriumShowSeatIds , int userId , int showId){
        for (int id : auditoriumShowSeatIds){
            ShowSeat seat = showSeatService.getShowSeat(id);
            if(!seat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new SeatNotAvailableException("Seat is not available");
            }
        }

         for (int id : auditoriumShowSeatIds){
             ShowSeat seat = showSeatService.getShowSeat(id);
             seat.setShowSeatStatus(ShowSeatStatus.LOCKED);
             showSeatService.saveShowSeat(seat);
         }
         boolean paymentStatus = startPayment(auditoriumShowSeatIds);
         if(paymentStatus){
             Ticket ticket = new Ticket();
             ticket.setTimeOfBooking(LocalDateTime.now());
             double amount = 0;
             for (int i = 0; i < auditoriumShowSeatIds.size(); i++) {
                 ShowSeat seat = showSeatService.getShowSeat(auditoriumShowSeatIds.get(i));
                 amount += seat.getPrice();
             }
             amount *= 1.18;          //adding 18% Gst
             ticket.setTotalAmount(amount);
             List<ShowSeat> bookedSeats = new ArrayList<>();
             for (int id : auditoriumShowSeatIds){
                 ShowSeat seat = showSeatService.getShowSeat(id);
                 seat.setShowSeatStatus(ShowSeatStatus.BOOKED);
                 bookedSeats.add(seat);
                 showSeatService.saveShowSeat(seat);
             }
             ticket.setShowSeats(bookedSeats);
             ticket.setAuditoriumShow(auditoriumShowService.getById(showId));
             ticket.setTicketStatus(TicketStatus.BOOKED);
             ticketRepository.save(ticket);
             return ticket;
         }
         throw new PaymentFailedException("Your payment was not successful");
    }

    public boolean startPayment(List<Integer> auditoriumShowSeatIds){
        return true;
    }
}
