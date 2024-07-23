package com.example.demo.controller;

import com.example.demo.config.JwtHelper;
import com.example.demo.dto.Login;
import com.example.demo.dto.SignupRequest;
import com.example.demo.model.Evenement;
import com.example.demo.model.Reservation;
import com.example.demo.model.User;
import com.example.demo.service.EvenementService;
import com.example.demo.service.ReservationService;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloEventController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private EvenementService evenementService;
    @Autowired
    private ReservationService reservationService;



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
        return evenementService.showEvents();
    }
    @DeleteMapping("/evenement/{id}")
    public void deleteEvent(@PathVariable Integer id){
        evenementService.deleteEvent(id);
    }
    @GetMapping("/evenement/{idEvent}")
    public Evenement showEvenement(@PathVariable Integer idEvent){
        return evenementService.showEvent(idEvent);
    }
    @PutMapping("/evenement/update/{idEvenement}")
    public Evenement updateEvenement(@PathVariable Integer idEvenement,@RequestBody Evenement evenement){
        return evenementService.updateEvent(idEvenement,evenement);

    }
    @GetMapping("/reservation")
    public List<Reservation> showReservations(){
        return reservationService.showReservations();
    }
    @GetMapping("/registres")
    public List<User> showRegisters(){
        return userService.findAllRegistre();
    }
    @DeleteMapping("/user/{idUser}")
    public void deleteUser(@PathVariable Integer idUser){
        userService.deleteUser(idUser);
    }
}
