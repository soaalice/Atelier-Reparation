package com.web.atelier.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="type_composant")
public class Type_composant {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String name;

}
