package com.web.atelier.Services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.atelier.Models.Client;
import com.web.atelier.Models.Composant;
import com.web.atelier.Models.Ordinateur;
import com.web.atelier.Models.Technicien;
import com.web.atelier.Repositories.ClientRepository;
import com.web.atelier.Repositories.ComposantRepository;
import com.web.atelier.Repositories.TechnicienRepository;

@Service
public class TechnicienService {
    @Autowired
    private TechnicienRepository technicienRepository;

    // Add a Techniciens
    public Technicien addTechnicien(Technicien Technicien) {
        return technicienRepository.save(Technicien);
    }

    // Get All Technicienss
    public List<Technicien> getAllTechniciens() {
        return technicienRepository.findAll();
    }

    // Get a Techniciens by its id
    public Technicien getTechnicienById(int id) {
        return technicienRepository.findById(id).orElse(null);
    }


    public List<Technicien> getTechnicienByDate(String minDate,String maxDate, Integer technicienId) {
        LocalDate dateMin =  LocalDate.of(1901, 1, 1) ;
        if (minDate != null && !minDate.isEmpty()) {
           dateMin = LocalDate.parse(minDate);  
        } 
        LocalDate dateMax =  LocalDate.of(2100, 12, 31);
        if(maxDate!=null && !maxDate.isEmpty()) {
            dateMax = LocalDate.parse(maxDate);
        }
        return technicienRepository.filterByDate(dateMin.toString(),dateMax.toString(), technicienId);
    }

}
