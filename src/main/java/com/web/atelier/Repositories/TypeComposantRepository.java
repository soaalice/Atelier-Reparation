package com.web.atelier.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.web.atelier.Models.TypeComposant;

@Repository
public interface TypeComposantRepository extends JpaRepository<TypeComposant,Integer> {

    
} 
