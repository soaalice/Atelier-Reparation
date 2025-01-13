package com.web.atelier.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.atelier.Models.Composant;
import com.web.atelier.Models.TypeComposant;
import com.web.atelier.Services.ComposantService;
import com.web.atelier.Services.TypeComposantService;

@Controller
public class ComposantController {
    @Autowired
    private ComposantService composantService;

    @Autowired
    private TypeComposantService typeComposantService;

    @GetMapping("/composants")
    public String showAllComposants(Model model){
        List<Composant> listComposants = composantService.getAllComposants();
        model.addAttribute("listComposant", listComposants);
        return "ListComposant";
    }

    @PostMapping("/composants")
    public String addModele(Composant composant,@RequestParam("typeComposantId") Integer typeComposantId, 
            RedirectAttributes redirectAttributes) {
        try {
            TypeComposant typeComposant = typeComposantService.getTypeComposantById(typeComposantId);
            composant.setTypeComposant(typeComposant);
            composantService.addComposant(composant);

            redirectAttributes.addFlashAttribute("successMessage", "Composant ajouté avec succès.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage",
                    "Erreur: "+e.getMessage());
        }
        return "redirect:/composants/form";
    }

    @GetMapping("/composants/form")
    public String showFormComposant(Model model) {
        List<TypeComposant> listTypeComposants = typeComposantService.getAllTypeComposants();
        model.addAttribute("listTypeComposant", listTypeComposants);
        return "FormComposant";
    }
}
