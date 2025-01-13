package com.web.atelier.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.web.atelier.Models.Unite;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeComposant {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(unique = true)
    String name;

    @ManyToOne
    @JoinColumn(name = "unite_id", nullable = false)
    private Unite unite;

}
