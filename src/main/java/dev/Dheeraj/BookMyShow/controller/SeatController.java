package dev.Dheeraj.BookMyShow.controller;

import dev.Dheeraj.BookMyShow.dto.SeatRequestDto;
import dev.Dheeraj.BookMyShow.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatController {
    @Autowired
    private SeatService seatService;

    @PostMapping("/addSeat")
    public ResponseEntity addSeats(@RequestBody SeatRequestDto seatRequestDto){
        return ResponseEntity.ok(
          seatService.addSeats(seatRequestDto.getRow(),
                  seatRequestDto.getCol(),
                  seatRequestDto.getSeatNumber(),
                  seatRequestDto.getSeatType(),
                  seatRequestDto.getAuditoriumId())
        );
    }

}
