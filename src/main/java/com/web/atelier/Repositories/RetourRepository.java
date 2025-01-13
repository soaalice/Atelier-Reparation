package com.web.atelier.Repositories;

import com.web.atelier.Models.Reparation;
import com.web.atelier.Models.Retour;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface RetourRepository extends JpaRepository<Retour, Integer> {
    @Query("SELECT re FROM Retour re JOIN "+
    "Reparation r ON r.id = re.reparation.id JOIN "+
    "ReparationDetails rd ON r.id=rd.reparation.id JOIN "+
    "Tarif t on rd.tarif.id = t.id JOIN "+
    "TypeReparation tr on t.typeReparation.id = tr.id JOIN " +
    "Composant c ON t.composant.id=c.id JOIN "+
    "TypeComposant tc ON c.typeComposant.id=tc.id WHERE "+
    " (:typeComposantId IS NULL OR tc.id=:typeComposantId) AND "+
    " (:typeReparationId IS NULL OR tr.id=:typeReparationId) ")
    List<Reparation> findByTypeComposantAndTypeReparation(@Param("typeComposantId") Integer typeComposantId);

}