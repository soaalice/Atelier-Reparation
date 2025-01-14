package com.web.atelier.Services;

import com.web.atelier.Models.Unite;
import com.web.atelier.Repositories.UniteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniteService {

    @Autowired
    private UniteRepository uniteRepository;

    public Unite addUnite(Unite Unite) {
        return uniteRepository.save(Unite);
    }

    public List<Unite> getAllUnites() {
        return uniteRepository.findAll();
    }

    public Unite getUniteById(int id) {
        return uniteRepository.findById(id).orElse(null);
    }
}