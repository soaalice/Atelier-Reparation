package com.web.atelier.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.atelier.Models.Ordinateur;

@Repository
public interface OrdinateurRepository extends JpaRepository<Ordinateur,Integer> {

    
} 
