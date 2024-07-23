package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

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


}
