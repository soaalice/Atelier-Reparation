package com.web.atelier.Repositories;

import com.web.atelier.Models.Modele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeleRepository extends JpaRepository<Modele, Integer> {


}
