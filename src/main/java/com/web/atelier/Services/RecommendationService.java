package com.web.atelier.Services;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.atelier.Models.Recommendation;
import com.web.atelier.Models.Recommendation;
import com.web.atelier.Models.Ordinateur;
import com.web.atelier.Repositories.RecommendationRepository;

@Service
public class RecommendationService {
    @Autowired
    private RecommendationRepository recommendationRepository;

    // Add a composant
    public Recommendation addRecommendation(Recommendation recommendation) {
        return recommendationRepository.save(recommendation);
    }

    // Get All Composants
    public List<Recommendation> getAllRecommendations() {
        return recommendationRepository.findAll();
    }

    // Get a composant by its id
    public Recommendation getRecommendationById(int id) {
        return recommendationRepository.findById(id).orElse(null);
    }

    public List<Recommendation> getFilterRecommendations(Integer typeComposantId,Date startDate,Date endDate){
        return recommendationRepository.filterByTypeComposantMonthYear(typeComposantId, startDate.getYear(), startDate.getMonth(),endDate.getYear(),endDate.getMonth());
    }
    
}
