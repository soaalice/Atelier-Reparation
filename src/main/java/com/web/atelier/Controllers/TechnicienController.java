package com.web.atelier.Controllers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.atelier.Models.Client;
import com.web.atelier.Models.Composant;
import com.web.atelier.Models.Sexe;
import com.web.atelier.Models.Tarif;
import com.web.atelier.Models.Technicien;
import com.web.atelier.Models.TypeReparation;
import com.web.atelier.Services.SexeService;
import com.web.atelier.Services.TechnicienService;


@Controller
public class TechnicienController {
    @Autowired
    private TechnicienService technicienService;

    @Autowired
    private SexeService sexeService;

    @GetMapping("/techniciens")
    public String showAllTechniciens(Model model) {
        List<Technicien> allTechniciens = technicienService.getAllTechniciens();
        model.addAttribute("listTechniciens", allTechniciens);
        return "ListTechnicien";
    }

    @GetMapping("/techniciens/form")
    public String showFormTechnicien(Model model) {
        List<Sexe> allSexe = sexeService.getAllSexe();
        model.addAttribute("listSexe", allSexe);
        return "FormTechnicien";
    }

     @PostMapping("/techniciens")
        public String addTechnicien(
            @RequestParam("name") String  name,
            @RequestParam("sexeId") Integer sexeId,
            RedirectAttributes redirectAttributes) {
            try {
                Technicien technicien = new Technicien();
                technicien.setName(name);
                technicien.setSexe(sexeService.getSexeById(sexeId));
                
                technicienService.addTechnicien(technicien);
                redirectAttributes.addFlashAttribute("successMessage", "Technicien ajouté avec succès !");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage", "Erreur: " + e.getMessage());
            }
            return "redirect:/techniciens/form";
        }

}
