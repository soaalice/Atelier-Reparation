package com.web.atelier.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.atelier.Models.TypeReparation;
import com.web.atelier.Repositories.TypeReparationRepository;

@Service
public class TypeReparationService {
    @Autowired
    private TypeReparationRepository typeReparationRepository;


    public TypeReparation addTypeReparation(TypeReparation typeReparation) {
        return typeReparationRepository.save(typeReparation);
    }

   
    public List<TypeReparation> getAllTypeReparations() {
        return typeReparationRepository.findAll();
    }


    public TypeReparation getTypeReparationById(int id) {
        return typeReparationRepository.findById(id).orElse(null);
    }
}