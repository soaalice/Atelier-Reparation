package com.web.atelier.Controllers;

import com.web.atelier.Models.TypeComposantModele;
import com.web.atelier.Models.Modele;
import com.web.atelier.Models.TypeComposant;
import com.web.atelier.Services.TypeComposantModeleService;
import com.web.atelier.Services.ModeleService;
import com.web.atelier.Services.TypeComposantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TypeComposantModeleController {

    @Autowired
    private TypeComposantModeleService typeComposantModeleService;

    @Autowired
    private ModeleService modeleService;

    @Autowired
    private TypeComposantService typeComposantService;

    @GetMapping("/typeComposantModeles")
    public String showAllTypeComposantModeles(Model model) {
        List<TypeComposantModele> listTypeComposantModeles = typeComposantModeleService.getAllTypeComposantModeles();
        model.addAttribute("listTypeComposantModeles", listTypeComposantModeles);
        return "ListTypeComposantModele";
    }

    @PostMapping("/typeComposantModeles")
    public String addTypeComposantModele(@RequestParam("modeleId") Integer modeleId,
            @RequestParam("typeComposantId") Integer typeComposantId,
            @RequestParam("min") Integer min,
            @RequestParam("max") Integer max) {
        Modele modele = modeleService.getModeleById(modeleId);
        TypeComposant typeComposant = typeComposantService.getTypeComposantById(typeComposantId);

        TypeComposantModele typeComposantModele = new TypeComposantModele();
        typeComposantModele.setModele(modele);
        typeComposantModele.setTypeComposant(typeComposant);
        typeComposantModele.setMin(min);
        typeComposantModele.setMax(max);

        typeComposantModeleService.addTypeComposantModele(typeComposantModele);
        return "redirect:/typeComposantModeles";
    }

    @GetMapping("/typeComposantModeles/form")
    public String showFormTypeComposantModele(Model model) {
        List<Modele> listModeles = modeleService.getAllModeles();
        List<TypeComposant> listTypeComposants = typeComposantService.getAllTypeComposants();
        model.addAttribute("listModeles", listModeles);
        model.addAttribute("listTypeComposants", listTypeComposants);
        return "FormTypeComposantModele";
    }
}