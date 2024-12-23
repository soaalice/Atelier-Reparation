package com.web.atelier.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.atelier.Models.Modele;
import com.web.atelier.Services.ModeleService;

@Controller
public class ModeleController {
    @Autowired
    private ModeleService modeleService;

    @GetMapping("/modeles")
    public String showAllModeles(Model model) {
        List<Modele> listModeles = modeleService.getAllModeles();
        model.addAttribute("listModeles", listModeles);
        return "ListModele";
    }

    @PostMapping("/modeles")
    public String addModele(Modele modele) {
        modeleService.addModele(modele);
        return "redirect:/modeles/form";
    }

    @GetMapping("/modeles/form")
    public String showFormModele() {
        return "FormModele";
    }
}