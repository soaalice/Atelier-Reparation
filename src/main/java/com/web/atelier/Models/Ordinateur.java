package com.web.atelier.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Data
public class Ordinateur {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name="modele_id")
    Modele modele;

    @Column
    String name;

}
