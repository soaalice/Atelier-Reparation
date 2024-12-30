package com.web.atelier.Repositories;

import com.web.atelier.Models.ComposantModele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComposantModeleRepository extends JpaRepository<ComposantModele, Integer> {
}