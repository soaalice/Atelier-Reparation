package com.web.atelier.Services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.atelier.Models.Sexe;
import com.web.atelier.Models.Composant;
import com.web.atelier.Models.Ordinateur;
import com.web.atelier.Repositories.ComposantRepository;
import com.web.atelier.Repositories.SexeRepository;

@Service
public class SexeService {
    @Autowired
    private SexeRepository sexeRepository;

    // Add a composant
    public Sexe addSexe(Sexe sexe) {
        return sexeRepository.save(sexe);
    }

    // Get All Composants
    public List<Sexe> getAllSexe() {
        return sexeRepository.findAll();
    }

    // Get a composant by its id
    public Sexe getSexeById(int id) {
        return sexeRepository.findById(id).orElse(null);
    }

}
