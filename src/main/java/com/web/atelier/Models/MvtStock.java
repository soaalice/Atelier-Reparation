package com.web.atelier.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MvtStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer entree = 0;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer sortie = 0;

    @ManyToOne
    @JoinColumn(name = "composant_id", nullable = false)
    private Composant composant;

    @Column(nullable = false)
    private LocalDate dateMvt;
}
