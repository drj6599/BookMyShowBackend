package dev.Dheeraj.BookMyShow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ActorResponseDto {
    private String name;
    private List<String> movieNames;
}
