package com.web.atelier.Services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.atelier.Models.Commission;
import com.web.atelier.Models.Composant;
import com.web.atelier.Models.Ordinateur;
import com.web.atelier.Repositories.ClientRepository;
import com.web.atelier.Repositories.CommissionRepository;
import com.web.atelier.Repositories.ComposantRepository;

@Service
public class CommissionService {
    @Autowired
    private CommissionRepository commissionRepository;

    // Add a composant
    public Commission addCommission(Commission commission) {
        return commissionRepository.save(commission);
    }

    // Get All Composants
    public List<Commission> getAllCommissions() {
        return commissionRepository.findAll();
    }

    // Get a composant by its id
    public Commission getCommissionById(int id) {
        return commissionRepository.findById(id).orElse(null);
    }

}
