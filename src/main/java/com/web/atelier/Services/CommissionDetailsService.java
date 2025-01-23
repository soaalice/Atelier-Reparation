package com.web.atelier.Services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.atelier.Models.Commission;
import com.web.atelier.Models.CommissionDetails;
import com.web.atelier.Models.Composant;
import com.web.atelier.Models.Ordinateur;
import com.web.atelier.Repositories.ClientRepository;
import com.web.atelier.Repositories.CommissionDetailsRepository;
import com.web.atelier.Repositories.CommissionRepository;
import com.web.atelier.Repositories.ComposantRepository;

@Service
public class CommissionDetailsService{
    @Autowired
    private CommissionDetailsRepository commissionDetailsRepository;

    // Add a composant
    public CommissionDetails addCommissionDetails(CommissionDetails commissionDetails) {
        return commissionDetailsRepository.save(commissionDetails);
    }

    // Get All Composants
    public List<CommissionDetails> getAllCommissionDetailss() {
        return commissionDetailsRepository.findAll();
    }

    // Get a composant by its id
    public CommissionDetails getCommissionDetailsById(int id) {
        return commissionDetailsRepository.findById(id).orElse(null);
    }

}
