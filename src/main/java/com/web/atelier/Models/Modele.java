package com.web.atelier.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Modele {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(unique = true)
    String name;

}
