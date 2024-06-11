package dev.Dheeraj.BookMyShow.controller;

import dev.Dheeraj.BookMyShow.dto.ShowSeatRequestDto;
import dev.Dheeraj.BookMyShow.service.ShowSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowSeatController {
    @Autowired
    private ShowSeatService showSeatService;

    @PostMapping("/createShowSeat")
    public ResponseEntity createShowSeat(@RequestBody ShowSeatRequestDto showSeatRequestDto){
        return ResponseEntity.ok(
                showSeatService.createShowSeat(
                        showSeatRequestDto.getPrice(),
                        showSeatRequestDto.getSeatId()
                )
        );
    }
}
