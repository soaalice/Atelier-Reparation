package com.web.atelier.Controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.atelier.Models.Reparation;
import com.web.atelier.Models.ReparationDetails;
import com.web.atelier.Models.Composant;
import com.web.atelier.Models.Ordinateur;
import com.web.atelier.Services.ReparationService;
import com.web.atelier.Services.TypeReparationService;
import com.web.atelier.Services.ComposantService;
import com.web.atelier.Services.OrdinateurService;
import com.web.atelier.Services.ReparationDetailsService;
import com.web.atelier.Services.TypeReparationService;

@Controller
public class ReparationDetailsController {

    @Autowired
    private ReparationDetailsService reparationDetailsService;
    @Autowired
    private ReparationService reparationService;
    @Autowired
    private ComposantService composantService;
    @Autowired
    private OrdinateurService ordinateurService;
    @Autowired
    private TypeReparationService typeReparationService;

    @PostMapping("/reparations-details")
    public String addReparation(Reparation reparation,
            @RequestParam("ordinateurId") Integer ordinateurId,
            @RequestParam("dateReparation") LocalDate dateReparation,Model model) {

            Ordinateur ordinateur = ordinateurService.getOrdinateurById(ordinateurId);
            model.addAttribute("ordinateurId", ordinateurId);
        model.addAttribute("dateReparation", dateReparation);
        model.addAttribute("listComposants", composantService.getComposantByOrdinateur(ordinateur));
        model.addAttribute("listTypeReparations", typeReparationService.getAllTypeReparations());
        return "FormReparationDetails";
    }

    @GetMapping("/reparations-details/form")
    public String showFormReparation(Model model) {
        model.addAttribute("listReparations",reparationService.getAllReparations());
        model.addAttribute("listComposants", composantService.getAllComposants());
        model.addAttribute("listTypeReparations", typeReparationService.getAllTypeReparations());
        return "FormReparationDetails";
    }

    
}
