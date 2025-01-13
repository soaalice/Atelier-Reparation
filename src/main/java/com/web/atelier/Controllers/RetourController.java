package com.web.atelier.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.atelier.Models.Retour;
import com.web.atelier.Models.Reparation;
import com.web.atelier.Models.Ordinateur;
import com.web.atelier.Services.RetourService;
import com.web.atelier.Services.ReparationService;
import com.web.atelier.Services.OrdinateurService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class RetourController {

    @Autowired
    private RetourService retourService;

    @Autowired
    private ReparationService reparationService;

    @Autowired
    private OrdinateurService ordinateurService;

    @GetMapping("/retours")
    public String showAllRetours(Model model) {
        model.addAttribute("listRetours", retourService.getAllRetours());
        return "ListRetour";
    }

    @PostMapping("/retours")
    public String addRetour(Retour retour,
            @RequestParam("reparationId") Integer reparationId,
            @RequestParam("dateRetour") LocalDate dateRetour,
            Model model,
            RedirectAttributes redirectAttributes) {

        try {
            Reparation reparation = reparationService.getReparationById(reparationId);
            retour.setDateRetour(dateRetour);
            retour.setReparation(reparation);

            retourService.addRetour(retour);

            redirectAttributes.addFlashAttribute("successMessage", "Retour ajouté avec succès !");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erreur: " + e.getMessage());
        }

        return "redirect:/retours/form";
    }

    @GetMapping("/retours/form")
    public String showFormRetour(Model model) {
        model.addAttribute("listReparations", reparationService.getReturnableReparations());
        return "FormRetour";
    }

}
