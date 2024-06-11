package dev.Dheeraj.BookMyShow.service;

import dev.Dheeraj.BookMyShow.model.Payment;
import dev.Dheeraj.BookMyShow.model.Ticket;
import dev.Dheeraj.BookMyShow.model.constant.PaymentMode;
import dev.Dheeraj.BookMyShow.model.constant.PaymentStatus;
import dev.Dheeraj.BookMyShow.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public boolean startPayment(Ticket ticket, double amount, PaymentMode paymentMode,String ref){
        Payment payment = new Payment();
        payment.setAmount(amount);
        payment.setTicket(ticket);
        payment.setPaymentMode(paymentMode);
        payment.setPaymentTime(LocalDateTime.now());
        payment.setPaymentStatus(PaymentStatus.SUCCESSFUL);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        payment.setReferenceId(encoder.encode(ref));
        paymentRepository.save(payment);
        return true;
    }

    public Payment getById(int paymentId){
        return paymentRepository.findById(paymentId).get();
    }
}
