package com.web.atelier.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="type_composant")
public class TypeComposant {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(unique = true)
    String name;

}
