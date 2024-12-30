package com.web.atelier.Services;

import com.web.atelier.Models.TypeComposantModele;
import com.web.atelier.Repositories.TypeComposantModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeComposantModeleService {

    @Autowired
    private TypeComposantModeleRepository typeComposantModeleRepository;

    public TypeComposantModele addTypeComposantModele(TypeComposantModele typeComposantModele) {
        return typeComposantModeleRepository.save(typeComposantModele);
    }

    public List<TypeComposantModele> getAllTypeComposantModeles() {
        return typeComposantModeleRepository.findAll();
    }

    public TypeComposantModele getTypeComposantModeleById(int id) {
        return typeComposantModeleRepository.findById(id).orElse(null);
    }
}