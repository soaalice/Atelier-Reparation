package com.web.atelier.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.atelier.Models.Reparation;
import com.web.atelier.Models.ReparationDetails;
import com.web.atelier.Repositories.ReparationDetailsRepository;
import com.web.atelier.Repositories.ReparationRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReparationDetailsService {

    @Autowired
    private ReparationDetailsRepository reparationDetailsRepository;

    // Ajouter une réparation
    @Transactional
    public ReparationDetails addReparationDetails(ReparationDetails reparation) {
        return reparationDetailsRepository.save(reparation);
    }

    // Obtenir toutes les réparations
    public List<ReparationDetails> getAllReparationsDetails() {
        return reparationDetailsRepository.findAll();
    }

    // Obtenir une réparation par son ID
    public ReparationDetails getReparationDetailsById(int id) {
        return reparationDetailsRepository.findById(id).orElse(null);
    }

    
}
