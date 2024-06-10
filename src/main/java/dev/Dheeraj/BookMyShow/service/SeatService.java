package dev.Dheeraj.BookMyShow.service;

import dev.Dheeraj.BookMyShow.model.Auditorium;
import dev.Dheeraj.BookMyShow.model.Seat;
import dev.Dheeraj.BookMyShow.model.constant.SeatStatus;
import dev.Dheeraj.BookMyShow.model.constant.SeatType;
import dev.Dheeraj.BookMyShow.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private AuditoriumService auditoriumService;

    public Seat addSeats(int row, int col, String seatNumber, String seatType, int auditoriumId){
        Seat seat = new Seat();
        seat.setSeatRow(row);
        seat.setSeatCol(col);
        seat.setSeatNumber(seatNumber);
        seat.setSeatType(SeatType.valueOf(seatType));
        seat.setSeatStatus(SeatStatus.AVAILABLE);
        Auditorium audi = auditoriumService.getById(auditoriumId);
        audi.getSeats().add(seat);
        seatRepository.save(seat);
        auditoriumService.update(audi);
        return null;
    }
}
