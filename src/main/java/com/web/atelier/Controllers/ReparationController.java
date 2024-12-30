package com.web.atelier.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.atelier.Models.Reparation;
import com.web.atelier.Models.Ordinateur;
import com.web.atelier.Services.ReparationService;
import com.web.atelier.Services.OrdinateurService;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
public class ReparationController {

    @Autowired
    private ReparationService reparationService;

    @Autowired
    private OrdinateurService ordinateurService;

    @GetMapping("/reparations")
    public String showAllReparations(Model model) {
        model.addAttribute("listReparations", reparationService.getAllReparations());
        return "ListReparation";
    }

    @PostMapping("/reparations")
    public String addReparation(Reparation reparation,
            @RequestParam("ordinateurId") Integer ordinateurId,
            @RequestParam("dateReparation") String dateReparation,
            @RequestParam("montantTotal") BigDecimal montantTotal,
            @RequestParam("dureeTotale") BigDecimal dureeTotale) {

        Ordinateur ordinateur = ordinateurService.getOrdinateurById(ordinateurId);
        reparation.setOrdinateur(ordinateur);
        reparation.setDateReparation(LocalDate.parse(dateReparation));
        reparation.setMontantTotal(montantTotal);
        reparation.setDureeTotale(dureeTotale);

        reparationService.addReparation(reparation);
        return "redirect:/reparations";
    }

    @GetMapping("/reparations/form")
    public String showFormReparation(Model model) {
        model.addAttribute("listOrdinateurs", ordinateurService.getAllOrdinateurs());
        return "FormReparation";
    }
}