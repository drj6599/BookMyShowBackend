package dev.Dheeraj.BookMyShow.controller;

import dev.Dheeraj.BookMyShow.dto.TheatreRequestDto;
import dev.Dheeraj.BookMyShow.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheatreController {
    @Autowired
    private TheatreService theatreService;

    @PostMapping("/theatre")
    public ResponseEntity createTheatre(@RequestBody TheatreRequestDto theatreRequestDto){
        return ResponseEntity.ok(
                theatreService.saveTheatres(theatreRequestDto.getName(),
                        theatreRequestDto.getAddress(),
                        theatreRequestDto.getCityId()
                )
        );
    }
}
