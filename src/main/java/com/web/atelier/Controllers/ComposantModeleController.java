package com.web.atelier.Controllers;

import com.web.atelier.Models.ComposantModele;
import com.web.atelier.Models.Composant;
import com.web.atelier.Models.Modele;
import com.web.atelier.Services.ComposantModeleService;
import com.web.atelier.Services.ComposantService;
import com.web.atelier.Services.ModeleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ComposantModeleController {

    @Autowired
    private ComposantModeleService composantModeleService;

    @Autowired
    private ComposantService composantService;

    @Autowired
    private ModeleService modeleService;

    @GetMapping("/composant-modeles")
    public String showAllComposantModeles(Model model) {
        List<ComposantModele> listComposantModeles = composantModeleService.getAllComposantModeles();
        model.addAttribute("listComposantModeles", listComposantModeles);
        return "ListComposantModele";
    }

    @PostMapping("/composant-modeles")
    public String addComposantModele(@RequestParam("composantId") Integer composantId,
            @RequestParam("modeleId") Integer modeleId) {
        Composant composant = composantService.getComposantById(composantId);
        Modele modele = modeleService.getModeleById(modeleId);

        ComposantModele composantModele = new ComposantModele();
        composantModele.setComposant(composant);
        composantModele.setModele(modele);

        composantModeleService.addComposantModele(composantModele);
        return "redirect:/composant-modeles/form";
    }

    @GetMapping("/composant-modeles/form")
    public String showFormComposantModele(Model model) {
        List<Composant> listComposants = composantService.getAllComposants();
        List<Modele> listModeles = modeleService.getAllModeles();
        model.addAttribute("listComposants", listComposants);
        model.addAttribute("listModeles", listModeles);
        return "FormComposantModele";
    }
}