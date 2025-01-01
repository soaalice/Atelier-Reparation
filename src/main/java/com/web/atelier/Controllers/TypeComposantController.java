package com.web.atelier.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.atelier.Models.TypeComposant;
import com.web.atelier.Services.TypeComposantService;

@Controller
public class TypeComposantController {

    @Autowired
    private TypeComposantService typeComposantService;

    // Affichage de la liste des types de composants
    @GetMapping("/type-composants")
    public String showAllTypeComposants(Model model) {
        List<TypeComposant> listTypeComposants = typeComposantService.getAllTypeComposants();
        model.addAttribute("listTypeComposants", listTypeComposants);
        return "ListTypeComposant"; // Affiche la page JSP avec la liste des types de composants
    }

    // Ajout d'un nouveau type de composant
    @PostMapping("/type-composants")
    public String addTypeComposant(TypeComposant typeComposant) {
        typeComposantService.addTypeComposant(typeComposant);
        return "redirect:/type-composants"; // Redirection vers la page de la liste des types de composants après ajout
    }

    // Affichage du formulaire pour ajouter un type de composant
    @GetMapping("/type-composants/form")
    public String showFormTypeComposant() {
        return "FormTypeComposant"; // Affiche un formulaire pour ajouter un nouveau type de composant
    }
}
