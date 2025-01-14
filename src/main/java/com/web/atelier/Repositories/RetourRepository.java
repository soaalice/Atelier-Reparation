package com.web.atelier.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.atelier.Models.Composant;
import com.web.atelier.Models.Retour;

@Repository
public interface RetourRepository extends JpaRepository<Retour, Integer> {
    @Query("SELECT r FROM Retour r JOIN ReparationDetails rd ON r.reparation.id=rd.reparation.id JOIN Tarif t ON rd.tarif.id=t.id JOIN Composant c ON c.id=t.composant.id WHERE (:typeComposantId IS NULL OR c.typeComposant.id = :typeComposantId) AND (:typeReparationId IS NULL OR t.typeReparation.id = :typeReparationId ) AND (:typeOrdinateurId IS NULL OR r.reparation.ordinateur.typeOrdinateur.id = :typeOrdinateurId)")
    List<Retour> filterByTypeComposantAndTypeReparation(
            @Param("typeComposantId") Integer typeComposantId,
            @Param("typeReparationId") Integer typeReparationId,@Param("typeOrdinateurId") Integer typeOrdinateur);
}
