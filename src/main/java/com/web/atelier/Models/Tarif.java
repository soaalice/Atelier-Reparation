package com.web.atelier.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Double prix;

    @Column(nullable = false)
    private Double duree;

    @ManyToOne
    @JoinColumn(name = "composant_id", nullable = false)
    private Composant composant;

    @ManyToOne
    @JoinColumn(name = "type_reparation_id", nullable = false)
    private TypeReparation typeReparation;
}