package com.web.atelier.Models;

import java.time.LocalDate;

import com.web.atelier.Models.Reparation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Retour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "reparation_id", nullable = false)
    private Reparation reparation;

    @Column(nullable = false)
    private LocalDate dateRetour;
}