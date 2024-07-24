package com.example.demo.controller;

import com.example.demo.config.JwtAuth;
import com.example.demo.model.Contact;
import com.example.demo.model.Evenement;
import com.example.demo.model.Reservation;
import com.example.demo.model.User;
import com.example.demo.service.ContactService;
import com.example.demo.service.EvenementService;
import com.example.demo.service.ReservationService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloEventController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private EvenementService evenementService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ContactService contactService;



    private final UserService userService;

    public HelloEventController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return userService.signUp(user);

    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        System.out.println("///////////////////"+user.getPassword()+"//////////////"+user.getUsername());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        String token = JwtAuth.generateToken(user.getUsername());
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);

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

    @GetMapping("/contacts")
    public List<Contact> showAllMessages(){
        return contactService.showAllMessages();
    }

    @PostMapping("/contact")
    public Contact sendMessage(@RequestBody Contact contact){
        return contactService.sendMessage(contact);
    }
    @GetMapping("/profile/{id}")
    public ResponseEntity<User> getUserProfile(@PathVariable Integer id) {
        User user = userService.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/profile/{id}")
    public User updateUserProfile(@PathVariable Integer id,@RequestBody User user) {
        return userService.updateProfile(id,user);
    }
    @GetMapping("/messages/{id}")
    public List<Contact> showMessageUser(@PathVariable Integer id){
        return contactService.showMessageUser(id);
    }
    @PostMapping ("/reservation")
    public Reservation addReservation(@RequestBody Reservation reservation){
        return reservationService.addReservation(reservation);
    }
    @GetMapping ("/reservations/{id}")
    public List<Reservation> showReservationsByIdUser(@PathVariable Integer id){
        return reservationService.showReservationsByIdUser(id);
    }
    @GetMapping("/titre")
    public List<Evenement> findEventByTitre(String titre){
        return evenementService.findEventByTitre(titre);
    }

}
