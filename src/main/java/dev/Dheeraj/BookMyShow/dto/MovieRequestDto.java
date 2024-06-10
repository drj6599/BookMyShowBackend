package dev.Dheeraj.BookMyShow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieRequestDto {
    private String name;
    private String description;
    private List<String> movieFeatures;
}
