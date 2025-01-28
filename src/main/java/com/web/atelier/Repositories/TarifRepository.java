package com.web.atelier.Repositories;

import com.web.atelier.Models.Composant;
import com.web.atelier.Models.Tarif;
import com.web.atelier.Models.TypeReparation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifRepository extends JpaRepository<Tarif, Integer> {
    @Query(value = "SELECT t.* FROM Tarif t WHERE t.composant_id = :composant " +
            "AND t.type_reparation_id = :typeReparation " +
            "AND t.date_tarif = (" +
            "SELECT MAX(ta.date_tarif) FROM Tarif ta " +
            "WHERE ta.composant_id = :composant " +
            "AND ta.type_reparation_id = :typeReparation " +
            "AND ta.date_tarif <= :date) LIMIT 1", nativeQuery = true)
    Tarif findOneLatestTarifByComposantAndType(
            @Param("composant") Long composant,
            @Param("typeReparation") Long typeReparation,
            @Param("date") LocalDate date);

    @Query(value = "SELECT t FROM Tarif t " +
            "WHERE (:composantId IS NULL OR t.composant.id = :composantId) " +
            "AND (:date IS NULL OR t.dateTarif = :date)")
    List<Tarif> findTarifByComposantAndDate(
            @Param("composantId") Long composantId,
            @Param("date") LocalDate date);

}