package com.web.atelier.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.atelier.Models.Composant;
import com.web.atelier.Models.Ordinateur;
import com.web.atelier.Models.Retour;
import com.web.atelier.Repositories.RetourRepository;

@Service
public class RetourService {
    @Autowired
    private RetourRepository retourRepository;

    // Add a retour
    public Retour addRetour(Retour retour) {
        return retourRepository.save(retour);
    }

    // Get All Composants
    public List<Retour> getAllRetours() {
        return retourRepository.findAll();
    }

    // Get a retour by its id
    public Retour getRetourById(int id) {
        return retourRepository.findById(id).orElse(null);
    }

    // Filtre par typeComposant et typeReparation
    public List<Retour> filterRetours(Integer typeComposantId, Integer typeReparationId) {
        return retourRepository.filterByTypeComposantAndTypeReparation(typeComposantId, typeReparationId);
    }
    

}
