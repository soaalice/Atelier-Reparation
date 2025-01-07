package com.web.atelier.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String addTypeReparation(TypeReparation typeReparation) {
        typeReparationService.addTypeReparation(typeReparation);
        return "redirect:/type-reparations/form";
    }

    @GetMapping("/type-reparations/form")
    public String showFormTypeReparation(Model model) {
        return "FormTypeReparation";
    }
}