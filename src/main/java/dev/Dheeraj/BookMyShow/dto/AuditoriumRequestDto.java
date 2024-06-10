package dev.Dheeraj.BookMyShow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuditoriumRequestDto {
    private int theatreId;
    private String name;
    private int capacity;
    private List<String> auditoriumFeatures;
}
