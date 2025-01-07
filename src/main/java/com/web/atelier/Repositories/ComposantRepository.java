package com.web.atelier.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.atelier.Models.Composant;

@Repository
public interface ComposantRepository extends JpaRepository<Composant,Integer> {

    @Query(value = "SELECT c FROM Composant c JOIN ComposantModele cm ON cm.composant=c WHERE cm.modele.id = (SELECT o.modele.id FROM Ordinateur o WHERE o.id=:ordinateurId)")
    List<Composant> findByOrdinateur(@Param("ordinateurId")Integer ordinateurId);
    
} 
