package com.web.atelier.Repositories;

import com.web.atelier.Models.Tarif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifRepository extends JpaRepository<Tarif, Integer> {
}