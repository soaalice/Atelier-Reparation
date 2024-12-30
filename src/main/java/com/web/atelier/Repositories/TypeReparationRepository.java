package com.web.atelier.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.atelier.Models.TypeReparation;

@Repository
public interface TypeReparationRepository extends JpaRepository<TypeReparation, Integer> {
}