package dev.Dheeraj.BookMyShow.controller;

import dev.Dheeraj.BookMyShow.dto.UserLoginRequestDto;
import dev.Dheeraj.BookMyShow.dto.UserSingUpRequestDto;
import dev.Dheeraj.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity singUp(@RequestBody UserSingUpRequestDto user){
        return ResponseEntity.ok(
                userService.signUp(user.getName(), user.getEmail(), user.getPassword())
        );
    }

    @GetMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginRequestDto user){
        return ResponseEntity.ok(
                userService.login(user.getEmail(), user.getPassword())
        );
    }
}
