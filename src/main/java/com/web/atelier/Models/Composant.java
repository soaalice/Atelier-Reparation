package com.web.atelier.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Composant {
    @Id
    int id;

    @ManyToOne
    @JoinColumn(name="type_composant_id")
    Type_composant type_composant;

    @Column
    String name;
}
