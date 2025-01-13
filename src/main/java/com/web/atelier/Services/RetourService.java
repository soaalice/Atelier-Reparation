package com.web.atelier.Services;

import com.web.atelier.Models.Retour;
import com.web.atelier.Repositories.RetourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetourService {

    @Autowired
    private RetourRepository retourRepository;

    public Retour addRetour(Retour Retour) {
        return retourRepository.save(Retour);
    }

    public List<Retour> getAllRetours() {
        return retourRepository.findAll();
    }

    public Retour getRetourById(int id) {
        return retourRepository.findById(id).orElse(null);
    }
}