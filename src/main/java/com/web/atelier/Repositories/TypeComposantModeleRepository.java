package com.web.atelier.Repositories;

import com.web.atelier.Models.TypeComposantModele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeComposantModeleRepository extends JpaRepository<TypeComposantModele, Integer> {
}