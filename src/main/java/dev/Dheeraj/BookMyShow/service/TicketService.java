package dev.Dheeraj.BookMyShow.service;

import dev.Dheeraj.BookMyShow.exception.PaymentFailedException;
import dev.Dheeraj.BookMyShow.exception.SeatNotAvailableException;
import dev.Dheeraj.BookMyShow.model.ShowSeat;
import dev.Dheeraj.BookMyShow.model.Ticket;
import dev.Dheeraj.BookMyShow.model.User;
import dev.Dheeraj.BookMyShow.model.constant.PaymentMode;
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
    @Autowired
    private UserService userService;

    @Transactional(isolation = Isolation.SERIALIZABLE)
     public Ticket bookTicket(List<Integer> auditoriumShowSeatIds , int userId , int showId){
        for (int id : auditoriumShowSeatIds){
            ShowSeat seat = showSeatService.getShowSeat(id);
            if(!seat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new SeatNotAvailableException("Seat is not available");
            }
        }
        double totalAmount = 0;
         for (int id : auditoriumShowSeatIds){
             ShowSeat seat = showSeatService.getShowSeat(id);
             seat.setShowSeatStatus(ShowSeatStatus.LOCKED);
             totalAmount += seat.getPrice();
             showSeatService.saveShowSeat(seat);
         }
         totalAmount *= 1.18;  //adding 18% GST
         Ticket ticket = new Ticket();
         boolean paymentStatus = paymentService.startPayment(ticket,totalAmount, PaymentMode.UPI ,"abcdefgh");
         if(paymentStatus){
             ticket.setTimeOfBooking(LocalDateTime.now());
             ticket.setTotalAmount(totalAmount);
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
             User user = userService.getById(userId);
             user.getTickets().add(ticket);
             userService.saveUser(user);
             return ticket;
         }
         throw new PaymentFailedException("Your payment was not successful");
    }

    public boolean startPayment(List<Integer> auditoriumShowSeatIds){
        return true;
    }
}
