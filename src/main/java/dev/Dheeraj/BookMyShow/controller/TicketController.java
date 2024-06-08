package dev.Dheeraj.BookMyShow.controller;

import dev.Dheeraj.BookMyShow.dto.BookTicketRequestDto;
import dev.Dheeraj.BookMyShow.exception.NoSeatsOrUserSelectedException;
import dev.Dheeraj.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;



    @PostMapping("/ticket")
    public ResponseEntity bookTicket(@RequestBody BookTicketRequestDto bookTicketRequestDto){
        if(bookTicketRequestDto.getAuditoriumShowSeatIds().size() == 0 || bookTicketRequestDto.getUserId() == null){
            throw new NoSeatsOrUserSelectedException("No seats selected / user Id is not present");
        }
        return ResponseEntity.ok(ticketService.bookTicket(bookTicketRequestDto.getAuditoriumShowSeatIds(), bookTicketRequestDto.getUserId()));
    }
}
