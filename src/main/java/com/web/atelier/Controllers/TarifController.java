package com.web.atelier.Controllers;

import com.web.atelier.Models.Tarif;
import com.web.atelier.Models.Composant;
import com.web.atelier.Models.TypeReparation;
import com.web.atelier.Services.TarifService;
import com.web.atelier.Services.ComposantService;
import com.web.atelier.Services.TypeReparationService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
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
    public String showAllTarifs(@RequestParam(value = "composantId",required = false)Long composantId,
            @RequestParam(value = "typeReparationId", required = false) Long typeReparationId,        
        @RequestParam(value = "date", required = false) String date,Model model) {
        List<Tarif> listTarifs = tarifService.getAllTarifs();
        List<Composant> listComposants = composantService.getAllComposants();
        if(composantId != null|| typeReparationId != null ||(date!=null && !date.isEmpty()) ){
            String localDate = null;
            if(date != null && !date.isEmpty()){
                localDate = LocalDate.parse(date).toString();
            }
            listTarifs = tarifService.getTarifByComposantAndDate(composantId,typeReparationId,localDate);
        }
        model.addAttribute("listTarifs", listTarifs);
        model.addAttribute("listTypeReparations",typeReparationService.getAllTypeReparations());
        model.addAttribute("listComposants", listComposants);
        return "ListTarif";
    }

        @PostMapping("/tarifs")
        public String addTarif(@RequestParam("prix") Double prix,
            @RequestParam("duree") Double duree,
            @RequestParam("composantId") Integer composantId,
            @RequestParam("typeReparationId") Integer typeReparationId,
                @RequestParam("date") String date,
            RedirectAttributes redirectAttributes) {
            try {
                Composant composant = composantService.getComposantById(composantId);
                TypeReparation typeReparation = typeReparationService.getTypeReparationById(typeReparationId);
                LocalDate localDate = LocalDate.parse(date);
                Tarif tarif = new Tarif();
                tarif.setPrix(prix);
                tarif.setDuree(duree);
                tarif.setComposant(composant);
                tarif.setTypeReparation(typeReparation);
                tarif.setDateTarif(localDate);

                tarifService.addTarif(tarif);
                redirectAttributes.addFlashAttribute("successMessage", "Tarif ajouté avec succès !");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage", "Erreur: " + e.getMessage());
            }
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