package com.web.atelier.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.atelier.Models.Composant;
import com.web.atelier.Repositories.ComposantRepository;

@Service
public class ComposantService {
    @Autowired
    private ComposantRepository composantRepository;
    //Add a composant
    public Composant addComposant(Composant composant){
        return composantRepository.save(composant);
    }

    //Get All Composants
    public List<Composant> getComposants(){
        return composantRepository.findAll();
    }

    //Get a composant by its id
    public Composant getComposantById(int id){
        return composantRepository.findById(id).orElse(null);
    }
}
