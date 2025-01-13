package com.web.atelier.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.atelier.Models.TypeReparation;
import com.web.atelier.Services.TypeReparationService;

@Controller
public class TypeReparationController {
    @Autowired
    private TypeReparationService typeReparationService;

    @GetMapping("/type-reparations")
    public String showAllTypeReparations(Model model) {
        List<TypeReparation> listTypeReparations = typeReparationService.getAllTypeReparations();
        model.addAttribute("listTypeReparations", listTypeReparations);
        return "ListTypeReparation";
        }

        @PostMapping("/type-reparations")
        public String addTypeReparation(TypeReparation typeReparation, RedirectAttributes redirectAttributes) {
            try {
                typeReparationService.addTypeReparation(typeReparation);
                redirectAttributes.addFlashAttribute("successMessage", "Type de réparation ajouté avec succès.");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage", "Erreur: " + e.getMessage());
            }
            return "redirect:/type-reparations/form";
        }

        @GetMapping("/type-reparations/form")
        public String showFormTypeReparation(Model model) {
        return "FormTypeReparation";
    }
}