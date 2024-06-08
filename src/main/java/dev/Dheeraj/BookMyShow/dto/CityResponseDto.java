package dev.Dheeraj.BookMyShow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityResponseDto {
    private int id;
    private String name;

    public CityResponseDto(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
