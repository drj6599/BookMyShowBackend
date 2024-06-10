package dev.Dheeraj.BookMyShow.controller;

import dev.Dheeraj.BookMyShow.dto.AuditoriumRequestDto;
import dev.Dheeraj.BookMyShow.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuditoriumController {
    @Autowired
    private AuditoriumService auditoriumService;

    @PostMapping("/addAuditorium")
    public ResponseEntity addAuditorium(@RequestBody AuditoriumRequestDto auditoriumRequestDto){
        return ResponseEntity.ok(
                auditoriumService.addAuditorium(auditoriumRequestDto.getTheatreId(),
                        auditoriumRequestDto.getName(),
                        auditoriumRequestDto.getCapacity(),
                        auditoriumRequestDto.getAuditoriumFeatures())
        );
    }
}
