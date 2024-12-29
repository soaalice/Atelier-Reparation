package com.web.atelier.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeComposantModele {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "modele_id", nullable = false)
    private Modele modele;

    @ManyToOne
    @JoinColumn(name = "type_composant_id", nullable = false)
    private TypeComposant typeComposant;

    @Column(nullable = false)
    private Integer min;

    @Column(nullable = false)
    private Integer max;
}