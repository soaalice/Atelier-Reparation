package com.web.atelier.Repositories;

import com.web.atelier.Models.TypeOrdinateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOrdinateurRepository extends JpaRepository<TypeOrdinateur, Integer> {
}