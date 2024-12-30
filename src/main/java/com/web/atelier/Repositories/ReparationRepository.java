package com.web.atelier.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.atelier.Models.Reparation;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReparationRepository extends JpaRepository<Reparation, Integer> {

    @Query("SELECT r FROM Reparation r WHERE " +
            "(:minDate IS NULL OR r.dateReparation >= CAST(:minDate AS date)) AND " +
            "(:maxDate IS NULL OR r.dateReparation <= CAST(:maxDate AS date)) AND " +
            "(:modele IS NULL OR LOWER(r.ordinateur.modele.name) LIKE CONCAT('%', LOWER(:modele), '%'))")
    List<Reparation> findByCriteria(
            @Param("minDate") String minDate,
            @Param("maxDate") String maxDate,
            @Param("modele") String modele);
}
