package com.web.atelier.Services;

import com.web.atelier.Models.Modele;
import com.web.atelier.Repositories.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeleService {

    @Autowired
    private ModeleRepository modeleRepository;

    // Ajouter un nouveau modèle
    public Modele addModele(Modele modele) {
        return modeleRepository.save(modele);
    }

    // Obtenir tous les modèles
    public List<Modele> getAllModeles() {
        return modeleRepository.findAll();
    }

    // Rechercher un modèle par ID
    public Modele getModeleById(int id) {
        return modeleRepository.findById(id).orElse(null);
    }

}
