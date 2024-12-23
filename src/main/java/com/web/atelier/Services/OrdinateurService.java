package com.web.atelier.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.atelier.Models.Ordinateur;
import com.web.atelier.Repositories.OrdinateurRepository;

@Service
public class OrdinateurService {
    @Autowired
    private OrdinateurRepository ordinateurRepository;

    //Add a new Ordinateur
    public Ordinateur addOrdinateur(Ordinateur ordinateur) {
        return ordinateurRepository.save(ordinateur);
    }

    //Get All Ordinateur
    public List<Ordinateur> getAllOrdinateurs(){
        return ordinateurRepository.findAll();
    }

    //Get an Ordinateur By its ID
    public Ordinateur getOrdinateurById(int id){
        return ordinateurRepository.findById(id).orElse(null);
    }
}
