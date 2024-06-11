package dev.Dheeraj.BookMyShow.controller;

import dev.Dheeraj.BookMyShow.service.AuditoriumShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuditoriumShowController {
    @Autowired
    private AuditoriumShowService auditoriumShowService;

    @PostMapping("/addShowToAuditorium")
    public ResponseEntity createData(){
        return ResponseEntity.ok(auditoriumShowService.createData());
    }
}
