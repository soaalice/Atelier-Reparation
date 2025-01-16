package com.web.atelier.Repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.atelier.Models.Client;
import com.web.atelier.Models.Composant;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

   
}
