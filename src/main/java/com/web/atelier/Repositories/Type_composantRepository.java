package com.web.atelier.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.web.atelier.Models.Type_composant;

@Repository
public interface Type_composantRepository extends JpaRepository<Type_composant,Integer> {

    
} 
