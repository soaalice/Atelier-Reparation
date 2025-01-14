package com.web.atelier.Repositories;

import com.web.atelier.Models.Unite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniteRepository extends JpaRepository<Unite, Integer> {
}