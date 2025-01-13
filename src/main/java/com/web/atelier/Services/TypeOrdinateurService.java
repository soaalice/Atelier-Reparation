package com.web.atelier.Services;

import com.web.atelier.Models.TypeOrdinateur;
import com.web.atelier.Repositories.TypeOrdinateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOrdinateurService {

    @Autowired
    private TypeOrdinateurRepository typeOrdinateurRepository;

    public TypeOrdinateur addTypeOrdinateur(TypeOrdinateur typeOrdinateur) {
        return typeOrdinateurRepository.save(typeOrdinateur);
    }

    public List<TypeOrdinateur> getAllTypeOrdinateurs() {
        return typeOrdinateurRepository.findAll();
    }

    public TypeOrdinateur getTypeOrdinateurById(int id) {
        return typeOrdinateurRepository.findById(id).orElse(null);
    }
}