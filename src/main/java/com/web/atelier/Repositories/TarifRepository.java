package com.web.atelier.Repositories;

import com.web.atelier.Models.Composant;
import com.web.atelier.Models.Tarif;
import com.web.atelier.Models.TypeReparation;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifRepository extends JpaRepository<Tarif, Integer> {
    @Query("SELECT t from Tarif t WHERE t.composant = :composant AND t.typeReparation = :typeReparation")
    Tarif findByComposantAndTypeReparation(Composant composant, TypeReparation typeReparation);
}