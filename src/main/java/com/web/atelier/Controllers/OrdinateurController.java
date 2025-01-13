package com.web.atelier.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.atelier.Models.Modele;
import com.web.atelier.Models.Ordinateur;
import com.web.atelier.Models.TypeOrdinateur;
import com.web.atelier.Services.ModeleService;
import com.web.atelier.Services.OrdinateurService;
import com.web.atelier.Services.TypeOrdinateurService;

@Controller
public class OrdinateurController {
    @Autowired
    private OrdinateurService ordinateurService;

    @Autowired
    private ModeleService modeleService;

    @Autowired
    private TypeOrdinateurService typeOrdinateurService;

    @GetMapping("/ordinateurs")
    public String showAllOrdinateurs(Model model) {
        List<Ordinateur> listOrdinateurs = ordinateurService.getAllOrdinateurs();
        model.addAttribute("listOrdinateurs", listOrdinateurs);
        return "ListOrdinateur";
        }

        @PostMapping("/ordinateurs")
        public String addOrdinateur(Ordinateur ordinateur, @RequestParam("modeleId") Integer modeleId, 
            @RequestParam("typeOrdinateurId") Integer typeOrdinateurId, RedirectAttributes redirectAttributes) {
            try {
                Modele modele = modeleService.getModeleById(modeleId);
                ordinateur.setModele(modele); 
                TypeOrdinateur to = typeOrdinateurService.getTypeOrdinateurById(typeOrdinateurId);
                ordinateur.setTypeOrdinateur(to);
                ordinateurService.addOrdinateur(ordinateur); 
                redirectAttributes.addFlashAttribute("successMessage", "Ordinateur ajouté avec succès !");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage", "Erreur: " + e.getMessage());
            }
            return "redirect:/ordinateurs/form";
        }

        @GetMapping("/ordinateurs/form")
        public String showFormOrdinateur(Model model) {
        List<Modele> listModele = modeleService.getAllModeles();
        model.addAttribute("listModele", listModele);
        model.addAttribute("listTypeOrdinateur", typeOrdinateurService.getAllTypeOrdinateurs());
        return "FormOrdinateur";
    }
}