package com.web.atelier.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String addModele(Composant composant,@RequestParam("typeComposantId") Integer typeComposantId) {
        TypeComposant typeComposant = typeComposantService.getTypeComposantById(typeComposantId);
        composant.setType_composant(typeComposant);
        composantService.addComposant(composant);
        return "redirect:/composants/form";
    }

    @GetMapping("/composants/form")
    public String showFormComposant(Model model) {
        List<TypeComposant> listTypeComposants = typeComposantService.getAllTypeComposants();
        model.addAttribute("listTypeComposant", listTypeComposants);
        return "FormComposant";
    }
}
