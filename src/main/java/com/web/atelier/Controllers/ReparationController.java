package com.web.atelier.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.atelier.Models.Reparation;
import com.web.atelier.Models.ReparationDetails;
import com.web.atelier.Models.Composant;
import com.web.atelier.Models.Ordinateur;
import com.web.atelier.Services.ReparationService;
import com.web.atelier.Services.TarifService;
import com.web.atelier.Services.TypeComposantService;
import com.web.atelier.Services.TypeReparationService;
import com.web.atelier.Services.ComposantService;
import com.web.atelier.Services.OrdinateurService;
import com.web.atelier.Services.ReparationDetailsService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Controller
public class ReparationController {

    @Autowired
    private ReparationService reparationService;

    @Autowired
    private OrdinateurService ordinateurService;

    @Autowired
    private ReparationDetailsService reparationDetailsService;

    @Autowired
    private TarifService tarifService;

    @Autowired
    private TypeComposantService typeComposantService;
    @Autowired
    private ComposantService composantService;


    @Autowired 
    private TypeReparationService typeReparationService;


    @GetMapping("/reparations")
    public String showAllReparations(@RequestParam(value="typeComposantId",required = false)Integer typeComposantId,Model model) {
        List<Reparation> list;
        if(typeComposantId!=null){
            list = reparationService.getReparationsByTypeComposant(typeComposantId);
        }
        else{
            list = reparationService.getAllReparations();
        }
        model.addAttribute("listTypeComposants",typeComposantService.getAllTypeComposants() );
        model.addAttribute("listReparations", list);
        return "ListReparation";
        }

        @PostMapping("/reparations")
        public String addReparation(Reparation reparation,
            @RequestParam("ordinateurId") Integer ordinateurId,
            @RequestParam("dateReparation") LocalDate dateReparation,
            @RequestParam("composants") List<Integer> composants,
            @RequestParam Map<String, String> typeReparations,
            Model model,
            RedirectAttributes redirectAttributes) {

            try {
                Ordinateur ordinateur = ordinateurService.getOrdinateurById(ordinateurId);
                reparation.setDateReparation(dateReparation);
                reparation.setOrdinateur(ordinateur);

                reparationService.addReparation(reparation);
                for (Integer long1 : composants) {
                    Composant tempComposant = composantService.getComposantById(long1);
                    Composant newComposant = composantService.getSuperiorOrMinorComposant(tempComposant,
                            Integer.parseInt(typeReparations.get("reparation_" + long1)));
                    ReparationDetails temp = new ReparationDetails();
                    temp.setTarif(tarifService.getTarifByComposantAndTypeReparation(tempComposant,
                            typeReparationService.getTypeReparationById(
                                    Integer.parseInt(typeReparations.get("reparation_" + long1)))));
                    temp.setReparation(reparation);
                    temp.setNewComposant(newComposant);

                    reparationDetailsService.addReparationDetails(temp);
                }

                redirectAttributes.addFlashAttribute("successMessage", "Réparation ajoutée avec succès !");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage", "Erreur: " + e.getMessage());
            }        
        return "redirect:reparations/form";
    }

        @GetMapping("/reparations/form")
        public String showFormReparation(Model model) {
        // model.addAttribute("listOrdinateurs", ordinateurService.getAllOrdinateurs());
        model.addAttribute("listOrdinateurs", ordinateurService.getAllRepairableOrdinateurs());
        return "FormReparation";
    }
    
    @GetMapping("/reparations/search")
    public String searchReparations(
            @RequestParam(value = "minDate", required = false) String minDateStr,
            @RequestParam(value = "maxDate", required = false) String maxDateStr,
            @RequestParam(value = "modele", required = false) String modele,
            Model model) {
        List<Reparation> reparations = reparationService.searchReparations(minDateStr, maxDateStr, modele);
        model.addAttribute("listReparations", reparations);

        return "ListReparation";
    }
}
