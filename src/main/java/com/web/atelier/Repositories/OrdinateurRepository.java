package com.web.atelier.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.atelier.Models.Ordinateur;
import java.util.List;

@Repository
public interface OrdinateurRepository extends JpaRepository<Ordinateur,Integer> {

    @Query("SELECT o FROM Ordinateur o WHERE o.id NOT IN (SELECT r.ordinateur.id FROM Reparation r)")
    List<Ordinateur> findNotRepaired();
} 