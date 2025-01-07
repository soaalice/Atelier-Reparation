package com.web.atelier.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.atelier.Models.ReparationDetails;

@Repository
public interface ReparationDetailsRepository extends JpaRepository<ReparationDetails, Integer> {

    
}
