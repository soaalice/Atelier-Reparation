package com.web.atelier.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.atelier.Models.Composant;

@Repository
public interface ComposantRepository extends JpaRepository<Composant,Integer> {

    
} 
