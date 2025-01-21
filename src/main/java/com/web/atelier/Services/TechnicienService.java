package com.web.atelier.Services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.atelier.Models.Client;
import com.web.atelier.Models.Composant;
import com.web.atelier.Models.Ordinateur;
import com.web.atelier.Models.Technicien;
import com.web.atelier.Repositories.ClientRepository;
import com.web.atelier.Repositories.ComposantRepository;
import com.web.atelier.Repositories.TechnicienRepository;

@Service
public class TechnicienService {
    @Autowired
    private TechnicienRepository technicienRepository;

    // Add a Techniciens
    public Technicien addTechnicien(Technicien Technicien) {
        return technicienRepository.save(Technicien);
    }

    // Get All Technicienss
    public List<Technicien> getAllTechniciens() {
        return technicienRepository.findAll();
    }

    // Get a Techniciens by its id
    public Technicien getTechnicienById(int id) {
        return technicienRepository.findById(id).orElse(null);
    }


}
