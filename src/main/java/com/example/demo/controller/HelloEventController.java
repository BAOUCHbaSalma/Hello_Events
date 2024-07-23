package com.example.demo.controller;

import com.example.demo.config.JwtHelper;
import com.example.demo.dto.Login;
import com.example.demo.dto.SignupRequest;
import com.example.demo.model.Evenement;
import com.example.demo.service.EvenementService;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloEventController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private EvenementService evenementService;



    private final UserService userService;

    public HelloEventController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@Valid @RequestBody SignupRequest requestDto) {
        userService.signUp(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody Login loginRequest) {
        System.out.println("/////////////////");
        System.out.println("////////////"+loginRequest.password()+"//////////"+loginRequest.username());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));

        if (authentication.isAuthenticated()) {
            String token = JwtHelper.generateToken(loginRequest.username());
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid login credentials");
        }
    }
    @PostMapping("/evenement")
    public Evenement addEvenement(@RequestBody Evenement evenement){
        return evenementService.addEvenement(evenement);
    }
    @GetMapping("/evenements")
    public List<Evenement> showEvenements(){
        return evenementService.showEvent();
    }
}
