package com.web.atelier.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web.atelier.Models.Reparation;
import com.web.atelier.Repositories.ReparationRepository;

import java.util.List;

@Service
public class ReparationService {

    @Autowired
    private ReparationRepository reparationRepository;

    // Ajouter une réparation
    public Reparation addReparation(Reparation reparation) {
        return reparationRepository.save(reparation);
    }

    // Obtenir toutes les réparations
    public List<Reparation> getAllReparations() {
        return reparationRepository.findAll();
    }

    // Obtenir une réparation par son ID
    public Reparation getReparationById(int id) {
        return reparationRepository.findById(id).orElse(null);
    }
}
