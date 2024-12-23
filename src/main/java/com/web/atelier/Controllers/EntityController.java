package com.web.atelier.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.web.atelier.Repositories.ModeleRepository;
import com.web.atelier.Repositories.TypeComposantRepository;
import com.web.atelier.Models.Modele;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EntityController {
    @Autowired
    private ModeleRepository modeleRepository;

    @Autowired
    private TypeComposantRepository typeComposantRepository;

    // Afficher le formulaire pour ajouter un Modele
    @GetMapping("/modele/form")
    public String showModeleForm() {
        return "Modele"; // Renvoie à Modele.jsp
    }

    @PostMapping("/modele/add")
    public String addModele(@ModelAttribute Modele modele) {
        modeleRepository.save(modele);
        return "redirect:/modele/form";
    }

    // Afficher le formulaire pour ajouter un Ordinateur
    @GetMapping("/ordinateur/form")
    public String showOrdinateurForm(Model model) {
        model.addAttribute("modeles", modeleRepository.findAll());
        return "Ordinateur"; // Renvoie à Ordinateur.jsp
    }

    // Afficher le formulaire pour ajouter un TypeComposant
    @GetMapping("/type-composant/form")
    public String showTypeComposantForm() {
        return "TypeComposant"; // Renvoie à TypeComposant.jsp
    }

    // Afficher le formulaire pour ajouter un Composant
    @GetMapping("/composant/form")
    public String showComposantForm(Model model) {
        model.addAttribute("typesComposants", typeComposantRepository.findAll());
        return "Composant"; // Renvoie à Composant.jsp
    }
}
