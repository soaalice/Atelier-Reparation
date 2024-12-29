package com.web.atelier.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComposantModele {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "composant_id", nullable = false)
    private Composant composant;

    @ManyToOne
    @JoinColumn(name = "modele_id", nullable = false)
    private Modele modele;
}