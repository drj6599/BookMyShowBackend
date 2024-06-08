package dev.Dheeraj.BookMyShow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheatreRequestDto {
    private String name;
    private String address;
    private int cityId;
}
