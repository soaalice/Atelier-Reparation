package com.web.atelier.Services;

import com.web.atelier.Models.ComposantModele;
import com.web.atelier.Repositories.ComposantModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComposantModeleService {

    @Autowired
    private ComposantModeleRepository composantModeleRepository;

    public ComposantModele addComposantModele(ComposantModele composantModele) {
        return composantModeleRepository.save(composantModele);
    }

    public List<ComposantModele> getAllComposantModeles() {
        return composantModeleRepository.findAll();
    }

    public ComposantModele getComposantModeleById(int id) {
        return composantModeleRepository.findById(id).orElse(null);
    }
}