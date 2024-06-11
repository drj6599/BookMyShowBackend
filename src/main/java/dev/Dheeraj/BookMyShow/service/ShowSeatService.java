package dev.Dheeraj.BookMyShow.service;

import dev.Dheeraj.BookMyShow.model.Seat;
import dev.Dheeraj.BookMyShow.model.ShowSeat;
import dev.Dheeraj.BookMyShow.model.constant.ShowSeatStatus;
import dev.Dheeraj.BookMyShow.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowSeatService {
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private SeatService seatService;

    public ShowSeat getShowSeat(int showSeatId){
        return showSeatRepository.findById(showSeatId).get();
    }

    public ShowSeat saveShowSeat(ShowSeat showSeat){
        return showSeatRepository.save(showSeat);
    }

    public ShowSeat createShowSeat(double price , int seatId){
        Seat seat = seatService.getById(seatId);
        ShowSeat showSeat = new ShowSeat();
        showSeat.setSeat(seat);
        showSeat.setPrice(price);
        showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
        showSeatRepository.save(showSeat);
        return showSeat;
    }
}
