package dev.Dheeraj.BookMyShow.controller;

import dev.Dheeraj.BookMyShow.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/getPayment/{id}")
    public ResponseEntity getPayment(@PathVariable("id") int paymentId){
        return ResponseEntity.ok(paymentService.getById(paymentId));
    }
}
