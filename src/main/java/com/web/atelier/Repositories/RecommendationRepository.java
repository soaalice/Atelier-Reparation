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

    @Query("SELECT r FROM Recommendation r WHERE ( :typeComposantId IS NULL OR r.composant.typeComposant.id = :typeComposantId) AND ( r.annee>=:anneeMin AND r.mois >= :moisMin) AND ( r.annee<=:anneeMax AND r.mois <= :moisMax) ")
    List<Recommendation> filterByTypeComposantMonthYear(@Param("typeComposantId") Integer typeComposantId,@Param("anneeMin") Integer anneeMin,@Param("moisMin") Integer moisMin,
            @Param("anneeMax") Integer anneeMax, @Param("moisMax") Integer moisMax);
    
}
