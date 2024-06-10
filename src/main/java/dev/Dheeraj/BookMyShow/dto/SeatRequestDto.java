package dev.Dheeraj.BookMyShow.dto;

import dev.Dheeraj.BookMyShow.model.constant.SeatType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatRequestDto {
    private int row;
    private int col;
    private String seatNumber;
    private String seatType;
    private int auditoriumId;
}
