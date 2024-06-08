package dev.Dheeraj.BookMyShow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDto {
    private List<Integer> auditoriumShowSeatIds;
    private Integer userId;
}
