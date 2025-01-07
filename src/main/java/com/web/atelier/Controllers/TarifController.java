package com.web.atelier.Controllers;

import com.web.atelier.Models.Tarif;
import com.web.atelier.Models.Composant;
import com.web.atelier.Models.TypeReparation;
import com.web.atelier.Services.TarifService;
import com.web.atelier.Services.ComposantService;
import com.web.atelier.Services.TypeReparationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TarifController {

    @Autowired
    private TarifService tarifService;

    @Autowired
    private ComposantService composantService;

    @Autowired
    private TypeReparationService typeReparationService;

    @GetMapping("/tarifs")
    public String showAllTarifs(Model model) {
        List<Tarif> listTarifs = tarifService.getAllTarifs();
        model.addAttribute("listTarifs", listTarifs);
        return "ListTarif";
    }

    @PostMapping("/tarifs")
    public String addTarif(@RequestParam("prix") Double prix,
            @RequestParam("duree") Double duree,
            @RequestParam("composantId") Integer composantId,
            @RequestParam("typeReparationId") Integer typeReparationId) {
        Composant composant = composantService.getComposantById(composantId);
        TypeReparation typeReparation = typeReparationService.getTypeReparationById(typeReparationId);

        Tarif tarif = new Tarif();
        tarif.setPrix(prix);
        tarif.setDuree(duree);
        tarif.setComposant(composant);
        tarif.setTypeReparation(typeReparation);

        tarifService.addTarif(tarif);
        return "redirect:/tarifs/form";
    }

    @GetMapping("/tarifs/form")
    public String showFormTarif(Model model) {
        List<Composant> listComposants = composantService.getAllComposants();
        List<TypeReparation> listTypeReparations = typeReparationService.getAllTypeReparations();
        model.addAttribute("listComposants", listComposants);
        model.addAttribute("listTypeReparations", listTypeReparations);
        return "FormTarif";
    }
}