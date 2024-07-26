package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Erole role ;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Reservation> reservationList ;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private  List<Contact> contactList;
    private String age;
//    @OneToMany
//    private List<Evenement> evenementList;
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (role == null) {
            // Handle the null case, possibly log an error or throw an exception
            System.out.println("Role is not initialized.");
            return List.of(); // or return an empty list or default role as needed
        }

        // Proceed if role is not null
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }


    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }
    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
