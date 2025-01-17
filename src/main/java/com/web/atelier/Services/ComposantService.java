package com.web.atelier.Services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.atelier.Models.Composant;
import com.web.atelier.Models.Ordinateur;
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
    public List<Composant> getAllComposants(){
        return composantRepository.findAll();
    }

    //Get a composant by its id
    public Composant getComposantById(int id){
        return composantRepository.findById(id).orElse(null);
    }

    public List<Composant> getComposantByOrdinateur(Ordinateur ordinateur){
        return composantRepository.findByOrdinateur(ordinateur.getId());
    }

    public List<Composant> getComposantsByType(Integer typeComposant){
        return composantRepository.findByType(typeComposant);
    }

    public Composant getSuperiorOrMinorComposant(Composant composant,int option){
        if(option==3){
            return composantRepository.findMinorComposant(composant.getValeur(),composant.getTypeComposant().getId());
        } else if (option == 4){
            return composantRepository.findSuperiorComposant(composant.getValeur(),composant.getTypeComposant().getId());
        }
        else{
            return composant;
        }
    }
}
