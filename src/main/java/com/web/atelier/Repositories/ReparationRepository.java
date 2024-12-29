package com.web.atelier.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.web.atelier.Models.Reparation;

@Repository
public interface ReparationRepository extends JpaRepository<Reparation, Integer> {

}
