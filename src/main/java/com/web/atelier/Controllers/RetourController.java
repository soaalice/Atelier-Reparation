package com.web.atelier.Controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.atelier.Models.Reparation;
import com.web.atelier.Models.Retour;
import com.web.atelier.Models.TypeComposant;
import com.web.atelier.Services.ReparationService;
import com.web.atelier.Services.RetourService;
import com.web.atelier.Services.TypeComposantService;
import com.web.atelier.Services.TypeReparationService;

@Controller
public class RetourController {
    @Autowired
    private RetourService retourService;

    @Autowired
    private ReparationService reparationService;

    @Autowired
    private TypeReparationService typeReparationService;

    @Autowired
    private TypeComposantService typeComposantService;

    @GetMapping("/retours")
    public String showAllComposants(@RequestParam(required = false) Integer typeComposantId,
            @RequestParam(required = false) Integer typeReparationId,Model model) {
        List<Retour> listRetour ;
        if(typeReparationId != null || typeComposantId != null){
            listRetour = retourService.filterRetours(typeComposantId, typeReparationId);
        }
        else{
            listRetour = retourService.getAllRetours();
        }
        model.addAttribute("listRetours", listRetour);
        model.addAttribute("listTypeComposants", typeComposantService.getAllTypeComposants());
        model.addAttribute("listTypeReparations", typeReparationService.getAllTypeReparations());
        return "ListRetour";
    }

    @PostMapping("/retours")
    public String addModele( @RequestParam(value="reparationId",required = true) Integer reparationId,@RequestParam(value="dateRetour" ,required=true) LocalDate date) {
        Retour retour = new Retour();
        retour.setDate(date);
        retour.setReparation(reparationService.getReparationById(reparationId));
        retourService.addRetour(retour);
        return "redirect:/retours/form";
    }

    @GetMapping("/retours/form")
    public String showFormComposant(Model model) {
        List<Reparation> listReparations = reparationService.getReparationNotReturned();
        model.addAttribute("listReparations", listReparations);
        return "FormRetour";
    }
}
