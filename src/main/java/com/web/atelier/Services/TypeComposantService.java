package com.web.atelier.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.atelier.Models.TypeComposant;
import com.web.atelier.Repositories.TypeComposantRepository;

@Service
public class TypeComposantService {
    @Autowired
    private TypeComposantRepository  typeComposantRepository;

    //Add a new TypeComposant
    public TypeComposant addTypeComposant(TypeComposant typeComposant){
        return typeComposantRepository.save(typeComposant);
    }

    //Get all TypeComposants
    public List<TypeComposant> getAllTypeComposants(){
        return typeComposantRepository.findAll();
    }

    //Get a TypeComposant by its Id
    public TypeComposant getTypeComposantById(int id){
        return typeComposantRepository.findById(id).orElse(null);
    }
}
