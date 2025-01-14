package com.web.atelier.Services;

import com.web.atelier.Models.Composant;
import com.web.atelier.Models.Tarif;
import com.web.atelier.Models.TypeReparation;
import com.web.atelier.Repositories.TarifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarifService {

    @Autowired
    private TarifRepository tarifRepository;

    public Tarif addTarif(Tarif tarif) {
        return tarifRepository.save(tarif);
    }

    public List<Tarif> getAllTarifs() {
        return tarifRepository.findAll();
    }

    public Tarif getTarifById(int id) {
        return tarifRepository.findById(id).orElse(null);
    }

    public Tarif getTarifByComposantAndTypeReparation(Composant composant, TypeReparation typeReparation) {
        return tarifRepository.findyByComposantAndTypeReparation(composant,typeReparation);
    }
}
