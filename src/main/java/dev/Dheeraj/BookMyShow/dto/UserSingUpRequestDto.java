package dev.Dheeraj.BookMyShow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSingUpRequestDto {
    private String name;
    private String email;
    private String password;
}
