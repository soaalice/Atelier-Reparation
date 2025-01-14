package com.web.atelier.Repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.atelier.Models.Composant;
import com.web.atelier.Models.Recommendation;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Integer> {

    
}
