package com.web.atelier.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web.atelier.Models.Reparation;
import com.web.atelier.Repositories.ReparationRepository;

import java.time.LocalDate;
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

    // Recherche des réparations par critères
    public List<Reparation> searchReparations(String minDateStr, String maxDateStr, String modele) {
        LocalDate minDate = (minDateStr != null && !minDateStr.isEmpty()) ? LocalDate.parse(minDateStr) : null;
        LocalDate maxDate = (maxDateStr != null && !maxDateStr.isEmpty()) ? LocalDate.parse(maxDateStr) : null;
        if(minDate!=null && maxDate!=null){
            return reparationRepository.findByCriteria(minDate, maxDate, modele);
        }
        else if(minDate==null && maxDate!=null){
            return reparationRepository.findByMaxDate(maxDate, modele);
        }
        else if(minDate!=null && maxDate==null){
            return reparationRepository.findByMinDate(minDate, modele);
        }
        else{
            return this.getAllReparations();
        }
    }
}
