package com.web.atelier.Services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.atelier.Models.Client;
import com.web.atelier.Models.Composant;
import com.web.atelier.Models.ConfigCommission;
import com.web.atelier.Models.Ordinateur;
import com.web.atelier.Repositories.ClientRepository;
import com.web.atelier.Repositories.ComposantRepository;
import com.web.atelier.Repositories.ConfigCommissionRepository;

@Service
public class ConfigCommissionService{
    @Autowired
    private ConfigCommissionRepository configCommissionRepository;

    // Add a composant
    public ConfigCommission addConfigCommission(ConfigCommission configCommission) {
        return configCommissionRepository.save(configCommission);
    }

    // Get All Composants
    public List<ConfigCommission> getAllConfigCommissions() {
        return configCommissionRepository.findAll();
    }

    // Get a composant by its id
    public ConfigCommission getConfigCommissionById(int id) {
        return configCommissionRepository.findById(id).orElse(null);
    }

}
