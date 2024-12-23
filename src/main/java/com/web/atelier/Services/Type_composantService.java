package com.web.atelier.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.atelier.Models.Type_composant;
import com.web.atelier.Repositories.Type_composantRepository;

@Service
public class Type_composantService {
    @Autowired
    private Type_composantRepository  type_composantRepository;

    //Add a new Type_composant
    public Type_composant addType_composant(Type_composant type_composant){
        return type_composantRepository.save(type_composant);
    }

    //Get all Type_composants
    public List<Type_composant> getAllType_composants(){
        return type_composantRepository.findAll();
    }

    //Get a Type_composant by its Id
    public Type_composant getType_composantById(int id){
        return type_composantRepository.findById(id).orElse(null);
    }
}
