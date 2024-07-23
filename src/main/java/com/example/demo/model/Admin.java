package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Admin {
    @Id
    private Integer idAdmin;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;
    

}
