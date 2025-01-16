package com.web.atelier.Controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.atelier.Models.Composant;
import com.web.atelier.Models.Modele;
import com.web.atelier.Models.Ordinateur;
import com.web.atelier.Models.Recommendation;
import com.web.atelier.Models.TypeComposant;
import com.web.atelier.Models.TypeOrdinateur;
import com.web.atelier.Services.ComposantService;
import com.web.atelier.Services.ModeleService;
import com.web.atelier.Services.OrdinateurService;
import com.web.atelier.Services.RecommendationService;
import com.web.atelier.Services.TypeComposantService;
import com.web.atelier.Services.TypeOrdinateurService;

@Controller
public class RecommendationController {
    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private ComposantService composantService;

    @Autowired
    private TypeComposantService typeComposantService;

    @GetMapping("/recommendations")
    public String showAllRecommendations(@RequestParam(value="typeComposantId",required = false) Integer typeComposantId,
                // @RequestParam(value="dateMin", required = false) String dateMinStr,
                // @RequestParam(value="dateMax",required = false) String dateMaxStr,
                @RequestParam(value="annee", required = false) Integer annee,
                @RequestParam(value = "mois", required = false) Integer mois,
                Model model) {
        List<Recommendation> list = recommendationService.getAllRecommendations();
        // Date startDate = Date.valueOf("1900-01-01");

        // if(dateMinStr!=null && !dateMinStr.isEmpty()){
        //     try {
        //         startDate = Date.valueOf(dateMinStr);
        //     } catch (Exception e) {
        //         System.err.println(e);
        //     }
        // }

        // Date endDate = Date.valueOf("2100-12-31");
        // if (dateMaxStr != null && !dateMaxStr.isEmpty()) {
        //     try {
        //         endDate = Date.valueOf(dateMaxStr);
        //     } catch (Exception e) {
        //         System.err.println(e);
        //     }
        // }

         Date endDate = Date.valueOf(LocalDate.now());
        if(annee ==null){
            annee = 2025;
        }
        
        // list = recommendationService.getFilterRecommendations(typeComposantId,startDate, endDate);
        //list = recommendationService.getFilterRecommendations(typeComposantId,endDate);
                    list = recommendationService.getFilterRecommendations(typeComposantId,mois,annee);
        List<TypeComposant> listTypeComposants = typeComposantService.getAllTypeComposants();
        model.addAttribute("listRecommendations", list);
        model.addAttribute("listTypeComposants", listTypeComposants);
        return "ListRecommendation";
    }

    @PostMapping("/recommendations")
    public String addRecommendation(@RequestParam("composantId") Integer composanId,
            @RequestParam("date") String date, RedirectAttributes redirectAttributes) {
        try {
            Composant composant = composantService.getComposantById(composanId);
            LocalDate localDate = LocalDate.parse(date);
            Recommendation recommendation = new Recommendation();
            recommendation.setAnnee(localDate.getYear());
            recommendation.setMois(localDate.getMonth().getValue());
            recommendation.setComposant(composant);
            recommendationService.addRecommendation(recommendation);
            redirectAttributes.addFlashAttribute("successMessage", "Recommendation ajouté avec succès !");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erreur: " + e.getMessage());
        }
        return "redirect:/recommendations/form";
    }

    @GetMapping("/recommendations/form")
    public String showFormOrdinateur(Model model) {
        List<Composant> list = composantService.getAllComposants();
        model.addAttribute("listComposants", list);
        return "FormRecommendation";
    }
}