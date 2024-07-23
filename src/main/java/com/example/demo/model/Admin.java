package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdmin;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;
//    @OneToMany(mappedBy = "admin")
//    @JsonIgnore
//    private List<Contact> contactList;


}
