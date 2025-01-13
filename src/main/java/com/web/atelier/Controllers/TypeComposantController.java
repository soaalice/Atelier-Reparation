package com.web.atelier.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.atelier.Models.TypeComposant;
import com.web.atelier.Models.Unite;
import com.web.atelier.Services.TypeComposantService;
import com.web.atelier.Services.UniteService;

@Controller
public class TypeComposantController {

    @Autowired
    private TypeComposantService typeComposantService;

    @Autowired
    private UniteService uniteService;

    // Affichage de la liste des types de composants
    @GetMapping("/type-composants")
    public String showAllTypeComposants(Model model) {
        List<TypeComposant> listTypeComposants = typeComposantService.getAllTypeComposants();
        model.addAttribute("listTypeComposants", listTypeComposants);
        return "ListTypeComposant";
    }

    // Ajout d'un nouveau type de composant
    @PostMapping("/type-composants")
    public String addTypeComposant(TypeComposant typeComposant, 
            @RequestParam("uniteId") Integer uniteId, RedirectAttributes redirectAttributes) {
        try {
            Unite u = uniteService.getUniteById(uniteId);
            typeComposant.setUnite(u);
            typeComposantService.addTypeComposant(typeComposant);
            redirectAttributes.addFlashAttribute("successMessage", "Type de composant ajouté avec succès.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erreur: " + e.getMessage());
        }
        return "redirect:/type-composants/form";
    }

    // Affichage du formulaire pour ajouter un type de composant
    @GetMapping("/type-composants/form")
    public String showFormTypeComposant(Model model) {
        model.addAttribute("listUnites", uniteService.getAllUnites());
        return "FormTypeComposant";
    }
}
