package com.web.atelier.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.atelier.Models.Modele;
import com.web.atelier.Models.Ordinateur;
import com.web.atelier.Models.TypeComposant;
import com.web.atelier.Services.ModeleService;
import com.web.atelier.Services.OrdinateurService;

@Controller
public class OrdinateurController {
    @Autowired
    private OrdinateurService ordinateurService;

    @Autowired
    private ModeleService modeleService;

    @GetMapping("/ordinateurs")
    public String showAllOrdinateurs(Model model) {
        List<Ordinateur> listOrdinateurs = ordinateurService.getAllOrdinateurs();
        model.addAttribute("listOrdinateurs", listOrdinateurs);
        return "ListOrdinateur";
    }

    @PostMapping("/ordinateurs")
    public String addOrdinateur(Ordinateur ordinateur, @RequestParam("modeleId") Integer modeleId) {
        Modele modele = modeleService.getModeleById(modeleId);
        ordinateur.setModele(modele); 
        ordinateurService.addOrdinateur(ordinateur); 
        return "redirect:/ordinateurs/form";
    }

    @GetMapping("/ordinateurs/form")
    public String showFormOrdinateur(Model model) {
        List<Modele> listModele = modeleService.getAllModeles();
        model.addAttribute("listModele", listModele);
        return "FormOrdinateur";
    }
}