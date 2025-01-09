package com.web.atelier.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReparationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "reparation_id", nullable = false)
    private Reparation reparation;

    @ManyToOne
    @JoinColumn(name="tarif_id", nullable = false)
    private Tarif tarif;

    // @Column(nullable = false)
    // private BigDecimal montantTotal;

    // @Column(nullable = false)
    // private BigDecimal dureeTotale;
}
